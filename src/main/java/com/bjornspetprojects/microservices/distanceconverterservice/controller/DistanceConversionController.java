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
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ResponseEntity<DistanceConversion> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/unit-rate/from/{from}/to/{to}",
                DistanceConversion.class,
                uriVariables);
        DistanceConversion response = responseEntity.getBody();
        System.out.println("RESPONSE :"+response.toString());
        return distanceConversionService.calculateDistanceConversion(from,to,originalAmount);
    }
}
