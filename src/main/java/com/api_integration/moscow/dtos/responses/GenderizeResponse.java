package com.api_integration.moscow.dtos.responses;

import lombok.Data;

@Data
public class GenderizeResponse {
    private String name;
    private String gender;
    private double probability;
    private int count;

}