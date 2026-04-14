package com.api_integration.moscow.service;


import com.api_integration.moscow.dtos.responses.GenderizeResponse;
import com.api_integration.moscow.service.GenderizeClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GenderizeClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public GenderizeResponse getGender(String name) {
        String url = "https://api.genderize.io/?name=" + name;
        return restTemplate.getForObject(url, GenderizeResponse.class);
    }
}
