package com.example.weatherdashboard.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class WeatherService {
    private HttpClient httpClient;
    private Map<String, String> cache = new HashMap<>();

    public WeatherService() {
        this.httpClient = HttpClients.createDefault();
    }

    public String getWeatherData(String location) {
        if (cache.containsKey(location)) {
            // Return cached data if available
            return cache.get(location);
        }

        String apiKey = "c860a21fc769fd9a52f24583da0092ce"; // Replace with your Weatherstack API key
        try {
            HttpGet httpGet = new HttpGet("http://api.weatherstack.com/current?access_key=" + apiKey + "&query=" + location);
            JSONObject response = new JSONObject(EntityUtils.toString(httpClient.execute(httpGet).getEntity()));
            String weatherData = response.toString();
            // Store data in the cache
            cache.put(location, weatherData);
            return weatherData;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error retrieving weather data";
        }
    }
}
