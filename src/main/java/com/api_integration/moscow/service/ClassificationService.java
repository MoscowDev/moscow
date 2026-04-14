package com.api_integration.moscow.service;


import com.api_integration.moscow.dtos.responses.GenderizeResponse;
import com.api_integration.moscow.dtos.responses.ProcessedResponse;
import org.springframework.stereotype.Service;

import java.time.Instant;
@Service
public class ClassificationService {

    private final GenderizeClient client;

    public ClassificationService(GenderizeClient client) {
        this.client = client;
    }

    public ProcessedResponse classify(String name) {

        GenderizeResponse apiResponse = client.getGender(name);

        ProcessedResponse response = new ProcessedResponse();
        ProcessedResponse.Data data = new ProcessedResponse.Data();

        data.setName(apiResponse.getName());
        data.setGender(apiResponse.getGender());
        data.setProbability(apiResponse.getProbability());
        data.setSampleSize(apiResponse.getCount());

        boolean isConfident =
                apiResponse.getProbability() >= 0.7 &&
                        apiResponse.getCount() >= 100;

        data.setConfident(isConfident);

        data.setProcessedAt(Instant.now().toString());

        response.setStatus("success");
        response.setData(data);

        return response;
    }
}