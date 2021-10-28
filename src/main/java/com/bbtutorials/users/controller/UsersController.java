package com.bbtutorials.users.controller;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.bbtutorials.users.entity.Users;
import com.bbtutorials.users.links.UserLinks;
import com.bbtutorials.users.service.UsersService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.client.RestTemplate;
import java.awt.PageAttributes.MediaType;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;


@Slf4j
@RestController
@RequestMapping("/api/")
public class UsersController {

    @Autowired
    UsersService usersService;
//    public static final String LIST_USERS = "/users";
//    public static final String ADD_USER = "/user";


    // @CrossOrigin
    // @GetMapping(path = UserLinks.LIST_USERS)
    // public ResponseEntity<?> listUsers() {
    //     log.info("UsersController:  list users");
    //     List<Users> resource = usersService.getUsers();
    //     System.out.println();
    //     return ResponseEntity.ok(resource);
    // }

    // @CrossOrigin
    // @PostMapping(path = UserLinks.ADD_USER)
    // public ResponseEntity<?> saveUser(@RequestBody Users user) {
    //     log.info("UsersController:  list users");
    //     Users resource = usersService.saveUser(user);
    //     return ResponseEntity.ok(resource);
    // }

    @CrossOrigin
    @PostMapping(value="/getRegister")
    public JSONObject getRegister(@RequestBody String dataBody){
        String firstName = "";
        String lastName = "";
        String email = "";
        String password = "";
        Users user = new Users("", "", "", "");
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(dataBody);
            firstName = json.getAsString("firstName");
            lastName = json.getAsString("lastName");
            email = json.getAsString("email");
            password = json.getAsString("password");
            user = new Users(firstName, lastName, email, password);
        }
        catch(Exception e){
            System.out.println("Sorry we have an error!");
        }
        return usersService.getRegister1(user);
    }


}
