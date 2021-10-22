package com.bbtutorials.users.service;


import java.util.List;
import java.util.Random;
import java.util.Arrays;

import com.bbtutorials.users.entity.Shows;
import com.bbtutorials.users.repository.ShowsRepository;
import org.springframework.stereotype.Component;

import com.bbtutorials.users.entity.Users;
import com.bbtutorials.users.repository.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public Object getWeather1(){
        String url = "https://api.openweathermap.org/data/2.5/weather?q=London&appid=b9c093c7f807a5ad859daac19b72b70f";
        RestTemplate restTemplate = new RestTemplate();
        Object s1= restTemplate.getForObject(url, Object.class);

        return s1;
    }
}
