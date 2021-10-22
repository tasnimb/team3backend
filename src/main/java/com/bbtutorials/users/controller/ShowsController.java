package com.bbtutorials.users.controller;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbtutorials.users.entity.Shows;
import com.bbtutorials.users.service.ShowsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/")
public class ShowsController {

    @Autowired
    ShowsService showsService;

//    @GetMapping(path = .LIST_SHOWS)//Need to figure out the link
    @GetMapping("/getShows")
    public ResponseEntity<?> listShows() {
        log.info("ShowsController:  list shows");
        List<Shows> resource = showsService.getShows();
        return ResponseEntity.ok(resource);
    }

//
    @PostMapping("/saveShows")
    public ResponseEntity<?> saveShows(@RequestBody Shows shows) {
        log.info("ShowsController:  list shows");
        Shows resource = showsService.saveShow(shows);
        return ResponseEntity.ok(resource);
    }


    @GetMapping(value="/getWeather")
    public Object getWeather(){
        return showsService.getWeather1();
    }

}
