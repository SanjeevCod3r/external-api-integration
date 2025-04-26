package com.sanjeev.extapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sanjeev.extapi.dto.WeatherResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final RestTemplate restTemplate;
    
    @Value("${weather.api.url}")
    private String apiUrl;
    
    @Value("${weather.api.key}")
    private String apiKey;
    
    public WeatherResponse getWeather(String city) {
        String url = String.format("%s/current.json?key=%s&q=%s", apiUrl, apiKey, city);
        return restTemplate.getForObject(url, WeatherResponse.class);
    }
}