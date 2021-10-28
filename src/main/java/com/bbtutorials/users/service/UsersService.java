package com.bbtutorials.users.service;

import java.util.List;
import java.util.Random;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.bbtutorials.users.entity.Users;
import com.bbtutorials.users.repository.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.micrometer.core.ipc.http.HttpSender.Response;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

@Component
public class UsersService {
	
	private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    // public List<Users> getUsers() {
    //     return usersRepository.findAll();
    // }
    
    // public Users saveUser(Users users) {
    // 	users.setId(new Random().nextInt());
    // 	return usersRepository.save(users);
    // }

    public JSONObject getRegister1(Users newUser){

        JSONObject jsonResponse = new JSONObject();
        Boolean validationPassed = true;
        String status = "PASSED";
        int invalidField = -1;

        List<Users> allUsers = usersRepository.findAll();
        for(Users user:allUsers){
            if((user.getEmail()).equals(newUser.getEmail())){//Check if email already registered
                validationPassed = false;
                status = "An account is already registered with this email";
                break;  
            }
           
        }
        //Check for email format

        //Check for blank fields

        //Check password - 4 characters 
        
        if(validationPassed){//Save the user only if it has passed the validation
            usersRepository.save(newUser);
        }
       
        String reponse = "{'validationPassed':"+validationPassed+", 'status':"+status+", 'invalidField':"+invalidField+"}";
        try{
            JSONParser parser = new JSONParser();
            jsonResponse = (JSONObject) parser.parse(reponse);
        }
        catch(Exception e){
            System.out.println("Sorry we have an error!");
        }
        return jsonResponse;
    }

}
