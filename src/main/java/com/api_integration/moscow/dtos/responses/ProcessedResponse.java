package com.api_integration.moscow.dtos.responses;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProcessedResponse {

    private String status;
    private Data data;
@lombok.Data
    public static class Data {
        private String name;
        private String gender;
        private double probability;

        @JsonProperty("sample_size")
        private int sampleSize;

        @JsonProperty("is_confident")
        private boolean isConfident;

        @JsonProperty("processed_at")
        private String processedAt;



}


}
