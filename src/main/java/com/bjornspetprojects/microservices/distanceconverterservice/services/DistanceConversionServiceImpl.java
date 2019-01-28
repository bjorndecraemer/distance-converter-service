package com.bjornspetprojects.microservices.distanceconverterservice.services;

import com.bjornspetprojects.microservices.distanceconverterservice.model.DistanceConversion;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DistanceConversionServiceImpl implements DistanceConversionService {
    @Override
    public DistanceConversion calculateDistanceConversion(String from, String to, BigDecimal originalAmount) {
        return DistanceConversion.builder().from(from).to(to).originalAmount(originalAmount).conversionFactor(new BigDecimal(12)).currentAmount(new BigDecimal(13)).build();
    }
}
