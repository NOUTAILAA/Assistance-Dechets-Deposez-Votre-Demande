package com.sjprogramming.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GeoController {

    @GetMapping("/api/geocode")
    public String getAddress(@RequestParam double lat, @RequestParam double lng) {
        String url = String.format("https://nominatim.openstreetmap.org/reverse?lat=%s&lon=%s&format=json", lat, lng);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        return response; // Vous pouvez ajuster cela pour retourner seulement l'adresse
    }
}