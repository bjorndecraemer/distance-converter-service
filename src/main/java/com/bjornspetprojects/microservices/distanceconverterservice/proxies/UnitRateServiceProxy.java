package com.bjornspetprojects.microservices.distanceconverterservice.proxies;

import com.bjornspetprojects.microservices.distanceconverterservice.model.UnitRate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "unit-rate-service", url="localhost:8000")
public interface UnitRateServiceProxy {
    @GetMapping("/unit-rate/from/{from}/to/{to}")
    UnitRate getUnitRate(@PathVariable String from, @PathVariable String to);
}
