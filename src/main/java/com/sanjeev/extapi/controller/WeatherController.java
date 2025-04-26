package com.sanjeev.extapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanjeev.extapi.dto.WeatherResponse;
import com.sanjeev.extapi.service.WeatherService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/weather")
public class WeatherController {
    private final WeatherService weatherService;
    
    @GetMapping("/{city}")
    public String getWeather(@PathVariable String city) {
        WeatherResponse response = weatherService.getWeather(city);
        return response.getSummary();
    }
}