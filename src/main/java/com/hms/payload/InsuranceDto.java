package com.hms.payload;

import lombok.Data;

@Data
public class InsuranceDto {
    private Long id;
    private String name;
    private String policyType;
    private long phoneNumber;
    private String address;

}
