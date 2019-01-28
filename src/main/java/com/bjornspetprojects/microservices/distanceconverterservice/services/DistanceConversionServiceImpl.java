package com.bjornspetprojects.microservices.distanceconverterservice.services;

import com.bjornspetprojects.microservices.distanceconverterservice.configuration.Configuration;
import com.bjornspetprojects.microservices.distanceconverterservice.model.DistanceConversion;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class DistanceConversionServiceImpl implements DistanceConversionService {

    private final Configuration configuration;
    private final Environment environment;

    public DistanceConversionServiceImpl(Configuration configuration, Environment environment) {
        this.configuration = configuration;
        this.environment = environment;
    }

    @Override
    public DistanceConversion calculateDistanceConversion(String from, String to, BigDecimal originalAmount) {
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ResponseEntity<DistanceConversion> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/unit-rate/from/{from}/to/{to}",
                DistanceConversion.class,
                uriVariables);
        DistanceConversion response = responseEntity.getBody();



        return DistanceConversion.builder()
                .environment(Arrays.toString(environment.getActiveProfiles()))
                .from(from)
                .to(to)
                .originalAmount(originalAmount)
                .conversionRate(response.getConversionRate())
                .currentAmount(originalAmount.multiply(response.getConversionRate(),new MathContext(configuration.getConversionPrecision())))
                .conversionPrecision(configuration.getConversionPrecision())
                .build();
    }
}
