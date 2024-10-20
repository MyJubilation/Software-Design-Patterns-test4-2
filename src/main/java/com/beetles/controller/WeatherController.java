package com.beetles.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author beetles
 * @date 2024/10/20
 * @Description
 */
@RestController
public class WeatherController {

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city) {
        String url = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getWeather?theCityCode={city}&theUserID=";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, city);
        return response.getBody();
    }
}