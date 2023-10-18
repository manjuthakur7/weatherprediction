package com.example.weatherdashboard;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class WeatherDashboard {

    public static void main(String[] args) {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://api.weatherstack.com/current?access_key=YOUR_API_KEY&query=New York");

        try {
            JSONObject response = new JSONObject(EntityUtils.toString(httpClient.execute(httpGet).getEntity()));
            // Process the JSON response here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
