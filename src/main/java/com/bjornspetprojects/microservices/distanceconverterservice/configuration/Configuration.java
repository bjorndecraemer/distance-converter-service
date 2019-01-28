package com.bjornspetprojects.microservices.distanceconverterservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("distance-converter-service")
public class Configuration {
    private int conversionPrecision;

    public int getConversionPrecision() {
        return conversionPrecision;
    }

    public void setConversionPrecision(int conversionPrecision) {
        this.conversionPrecision = conversionPrecision;
    }
}
