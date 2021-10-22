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
        shows.setId(new Random().nextInt());
        return showsRepository.save(shows);
    }

    public String getWeather1(String city){
        String url = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=b9c093c7f807a5ad859daac19b72b70f";
        RestTemplate restTemplate = new RestTemplate();
        String s1= restTemplate.getForObject(url, String.class);
        return s1;
    }

    public String getFlightDetails1(String outBoundCity, String inBoundCity){
        String URL = "https://test.api.amadeus.com/v2/shopping/flight-offers?originLocationCode="+outBoundCity+"&destinationLocationCode="+inBoundCity+"&departureDate=2021-11-01&returnDate=2021-11-25&adults=1&travelClass=FIRST&nonStop=false&currencyCode=GBP&max=5";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "Bearer tlmhcrxtdfyu9iH2Gq9vTvLx4Rgt");
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                URL,
                HttpMethod.GET,
                request,
                String.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful.");
            System.out.println(response.getBody());
        } else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        }
        return response.getBody();
    }

}
