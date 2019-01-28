package com.bjornspetprojects.microservices.distanceconverterservice.services;

import com.bjornspetprojects.microservices.distanceconverterservice.configuration.Configuration;
import com.bjornspetprojects.microservices.distanceconverterservice.model.DistanceConversion;
import com.bjornspetprojects.microservices.distanceconverterservice.model.UnitRate;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Objects;

@Service
public class DistanceConversionServiceImpl implements DistanceConversionService {

    private final Configuration configuration;
    private final Environment environment;

    public DistanceConversionServiceImpl(Configuration configuration, Environment environment) {
        this.configuration = configuration;
        this.environment = environment;
    }

    @Override
    public DistanceConversion calculateDistanceConversion(UnitRate unitRate, BigDecimal originalAmount) {
        BigDecimal conversionRate = unitRate.getConversionRate();
        int port =  Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port")));
        return DistanceConversion.builder()
                .environment(Arrays.toString(environment.getActiveProfiles()))
                .from(unitRate.getFrom())
                .to(unitRate.getTo())
                .originalAmount(originalAmount)
                .conversionRate(conversionRate)
                .currentAmount(originalAmount.multiply(conversionRate,new MathContext(configuration.getConversionPrecision())))
                .conversionPrecision(configuration.getConversionPrecision())
                .distanceConverterServicePort(port)
                .unitRateServicePort(unitRate.getPort())
                .build();

    }
}
