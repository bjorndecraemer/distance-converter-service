package com.bjornspetprojects.microservices.distanceconverterservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitRate {
    private String from;
    private String to;
    private BigDecimal conversionRate;
    private int port;
}
