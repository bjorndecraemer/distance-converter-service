package com.bjornspetprojects.microservices.distanceconverterservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DistanceConversion {
    private String environment;
    private String from;
    private String to;
    private BigDecimal conversionRate;
    private BigDecimal originalAmount;
    private BigDecimal currentAmount;
    private Integer conversionPrecision;
}
