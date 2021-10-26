package com.bbtutorials.users.service;


import java.util.List;
import java.util.Random;
import java.util.Arrays;

import com.bbtutorials.users.entity.Shows;
import com.bbtutorials.users.repository.ShowsRepository;
import org.springframework.http.*;
import org.springframework.stereotype.Component;

import com.bbtutorials.users.entity.Users;
import com.bbtutorials.users.repository.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.minidev.json.JSONObject;


import java.util.*;


@Component
public class ShowsService {

    private ShowsRepository showsRepository;

    public ShowsService(ShowsRepository showsRepository) {
        this.showsRepository = showsRepository;
    }

    public List<Shows> getShows() {
        return showsRepository.findAll();
    }
    public Shows saveShow(Shows shows) {
        shows.setId(new Random().nextInt());//hellotesting the jenkins pipeline
        return showsRepository.save(shows);
    }

    public String getWeather1(String latitude, String longitude){
        String URL = "https://api.openweathermap.org/data/2.5/onecall?lat="+latitude+"&lon="+longitude+"&exclude=minutely,hourly,alerts&appid=1104723fcfd67fbc35aef74bd9247c19";
        RestTemplate restTemplate = new RestTemplate();
        String results = restTemplate.getForObject(URL, String.class);
        return results;
    }

    public String getFlightDetails1(String depCity, String arrCity, String depDate, String retDate){
        String URL = "https://test.api.amadeus.com/v2/shopping/flight-offers?originLocationCode="+depCity+"&destinationLocationCode="+arrCity+"&departureDate="+depDate+"&returnDate="+retDate+"&adults=1&travelClass=FIRST&nonStop=false&currencyCode=GBP&max=3";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "Bearer usxLMN9G7Y0KUbX6613ccgEQBIPa");
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                URL,
                HttpMethod.GET,
                request,
                String.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful.");
            System.out.println("===========================================");
        } else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        }
        return response.getBody();
    }

    public String getFlightPrice1(JSONObject searchData){
        String URL = "https://test.api.amadeus.com/v1/shopping/flight-offers/pricing";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer usxLMN9G7Y0KUbX6613ccgEQBIPa");

        HttpEntity request = new HttpEntity(searchData, headers);

        ResponseEntity<String> response = restTemplate.exchange(
            URL,
            HttpMethod.POST,
            request,
            String.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful.");
            System.out.println("===========================================");
        } 
        else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        }
        return response.getBody();
    }

}
