package com.example.weatherdashboard.controller;

import org.junit.Test;
import static org.junit.Assert.*;

public class WeatherControllerTest {

    @Test
    public void testGetWeatherForValidLocation() {
        WeatherController weatherController = new WeatherController();
        String weatherData = weatherController.getWeatherForLocation("New York");
        assertNotNull(weatherData);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWeatherForInvalidLocation() {
        WeatherController weatherController = new WeatherController();
        weatherController.getWeatherForLocation("");
    }
}
