package com.bjornspetprojects.microservices.distanceconverterservice.controller;

import com.bjornspetprojects.microservices.distanceconverterservice.model.DistanceConversion;
import com.bjornspetprojects.microservices.distanceconverterservice.model.UnitRate;
import com.bjornspetprojects.microservices.distanceconverterservice.proxies.UnitRateServiceProxy;
import com.bjornspetprojects.microservices.distanceconverterservice.services.DistanceConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class DistanceConversionController {

    private final DistanceConversionService distanceConversionService;
    private final UnitRateServiceProxy unitRateServiceProxy;

    public DistanceConversionController(DistanceConversionService distanceConversionService, UnitRateServiceProxy unitRateServiceProxy) {
        this.distanceConversionService = distanceConversionService;
        this.unitRateServiceProxy = unitRateServiceProxy;
    }

    @GetMapping("/distance-conversion/from/{from}/to/{to}/amount/{originalAmount}")
    public DistanceConversion getDistanceConversion(@PathVariable String from,
                                                    @PathVariable String to,
                                                    @PathVariable BigDecimal originalAmount){
        UnitRate proxyResult = unitRateServiceProxy.getUnitRate(from,to);

        return distanceConversionService.calculateDistanceConversion(proxyResult,originalAmount);
    }
}
