package com.example.weatherdashboard.controller;
import java.util.concurrent.CompletableFuture;

import com.example.weatherdashboard.service.WeatherService;

public class WeatherController {
    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    public CompletableFuture<String> getWeatherForLocationAsync(String location) {
        return CompletableFuture.supplyAsync(() -> {
            String weatherData = weatherService.getWeatherData(location);
            return weatherData;
        });
    }


    private String temperatureUnit = "Celsius"; // Default temperature unit

    public void setTemperatureUnit(String unit) {
        if (unit.equals("Celsius") || unit.equals("Fahrenheit")) {
            this.temperatureUnit = unit;
        } else {
            throw new IllegalArgumentException("Invalid temperature unit.");
        }
    }

    public String getWeatherForLocation(String location) {
        try {
            String weatherData = weatherService.getWeatherData(location);
            return weatherData;
        } catch (Exception ex) {
            // Log the error for debugging
            ex.printStackTrace();
            // Provide a more informative error message to the user
            return "An error occurred while fetching weather data: " + ex.getMessage();
        }
    }
}


   
    