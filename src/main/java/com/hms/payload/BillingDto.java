package com.hms.payload;

import lombok.Data;

@Data
public class BillingDto {
    private Long id;
    private String insuranceProvider;
    private String policyNumber;
    private double totalAmount;
}
