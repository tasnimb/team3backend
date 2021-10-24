package com.bbtutorials.users.controller;

import com.bbtutorials.users.entity.Shows;
import com.bbtutorials.users.service.ShowsService;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.writer.*;
import net.minidev.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/")
public class
ShowsController {

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

    @CrossOrigin
    @PostMapping(value="/getWeather")
    public String getWeather(@RequestBody String dataBody){
        String city ="";
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(dataBody);
            city = json.getAsString("city");

        }
        catch(Exception e){
            System.out.println("Sorry we have an error!");
        }

        return showsService.getWeather1(city);
    }

    @CrossOrigin
    @PostMapping(value="/getFlightDetails")
    public String getFlightDetails(@RequestBody String dataBody){
        String outBoundCity="";
        String inBoundCity="";
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(dataBody);
            outBoundCity = json.getAsString("outBoundCity");
            inBoundCity = json.getAsString("inBoundCity");
        }
        catch(Exception e){
            System.out.println("Sorry we have an error!");
        }

        return showsService.getFlightDetails1(outBoundCity, inBoundCity);
    }

    @CrossOrigin
    @PostMapping(value="/getFlightPrice")
    public String getFlightPrice(@RequestBody String dataBody){
        JSONObject searchData = new JSONObject();
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(dataBody);
            searchData =  (JSONObject) (json.get("searchData"));
            
        }
        catch(Exception e){
            System.out.println("Sorry we have an error!");
        }
        return showsService.getFlightPrice1(searchData);
    }

    



}
