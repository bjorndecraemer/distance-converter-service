package com.bjornspetprojects.microservices.distanceconverterservice.services;

import com.bjornspetprojects.microservices.distanceconverterservice.configuration.Configuration;
import com.bjornspetprojects.microservices.distanceconverterservice.model.DistanceConversion;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

@Service
public class DistanceConversionServiceImpl implements DistanceConversionService {

    private final Configuration configuration;
    private final Environment environment;

    public DistanceConversionServiceImpl(Configuration configuration, Environment environment) {
        this.configuration = configuration;
        this.environment = environment;
    }

    @Override
    public DistanceConversion calculateDistanceConversion(DistanceConversion distanceConversion, BigDecimal originalAmount) {
        BigDecimal conversionRate = distanceConversion.getConversionRate();

        return DistanceConversion.builder()
                .environment(Arrays.toString(environment.getActiveProfiles()))
                .from(distanceConversion.getFrom())
                .to(distanceConversion.getTo())
                .originalAmount(originalAmount)
                .conversionRate(conversionRate)
                .currentAmount(originalAmount.multiply(conversionRate,new MathContext(configuration.getConversionPrecision())))
                .conversionPrecision(configuration.getConversionPrecision())
                .build();

    }
}
