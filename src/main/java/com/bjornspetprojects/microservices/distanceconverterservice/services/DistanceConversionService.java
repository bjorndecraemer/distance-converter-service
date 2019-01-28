package com.bjornspetprojects.microservices.distanceconverterservice.services;

import com.bjornspetprojects.microservices.distanceconverterservice.model.DistanceConversion;
import com.bjornspetprojects.microservices.distanceconverterservice.model.UnitRate;

import java.math.BigDecimal;

public interface DistanceConversionService {
    DistanceConversion calculateDistanceConversion(UnitRate unitRate, BigDecimal originalAmount);
}
