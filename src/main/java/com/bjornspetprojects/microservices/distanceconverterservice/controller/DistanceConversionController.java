package com.bjornspetprojects.microservices.distanceconverterservice.controller;

import com.bjornspetprojects.microservices.distanceconverterservice.model.DistanceConversion;
import com.bjornspetprojects.microservices.distanceconverterservice.services.DistanceConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DistanceConversionController {

    private final DistanceConversionService distanceConversionService;

    public DistanceConversionController(DistanceConversionService distanceConversionService) {
        this.distanceConversionService = distanceConversionService;
    }

    @GetMapping("/distance-conversion/from/{from}/to/{to}/amount/{originalAmount}")
    public DistanceConversion getDistanceConversion(@PathVariable String from,
                                                    @PathVariable String to,
                                                    @PathVariable BigDecimal originalAmount){
        return distanceConversionService.calculateDistanceConversion(from,to,originalAmount);
    }
}
