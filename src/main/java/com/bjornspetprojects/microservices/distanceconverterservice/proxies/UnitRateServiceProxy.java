package com.bjornspetprojects.microservices.distanceconverterservice.proxies;

import com.bjornspetprojects.microservices.distanceconverterservice.model.UnitRate;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "unit-conversion-netflix-zuul-service")
@RibbonClient(name = "unit-rate-service")
public interface UnitRateServiceProxy {
    @GetMapping("/unit-rate-service/unit-rate/from/{from}/to/{to}")
    UnitRate getUnitRate(@PathVariable String from, @PathVariable String to);
}
