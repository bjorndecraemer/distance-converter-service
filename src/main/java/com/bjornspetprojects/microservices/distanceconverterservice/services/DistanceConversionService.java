package com.bjornspetprojects.microservices.distanceconverterservice.services;

import com.bjornspetprojects.microservices.distanceconverterservice.model.DistanceConversion;

import java.math.BigDecimal;

public interface DistanceConversionService {
    DistanceConversion calculateDistanceConversion(String from, String to, BigDecimal originalAmount);
}
