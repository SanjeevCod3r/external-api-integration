package com.sanjeev.extapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    @JsonProperty("location")
    private Location location;
    
    @JsonProperty("current")
    private Current current;
    
    // Helper method to get simplified response
    public String getSummary() {
        return String.format("%s: %.1f°C, %s", 
            location.name, 
            current.tempC, 
            current.condition.text);
    }
    
    @Data
    public static class Location {
        private String name;
    }
    
    @Data
    public static class Current {
        @JsonProperty("temp_c")
        private double tempC;
        
        @JsonProperty("condition")
        private Condition condition;
    }
    
    @Data
    public static class Condition {
        private String text;
    }
}