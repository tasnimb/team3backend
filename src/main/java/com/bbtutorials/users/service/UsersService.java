package com.bbtutorials.users.service;

import java.util.List;
import java.util.Random;
import java.util.Arrays;
import java.util.regex.Pattern;

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

    public JSONObject getLoggedIn(String email, String password){
        boolean valid = false;
        JSONObject jsonResponse = new JSONObject();
        List<Users> allUsers = usersRepository.findAll();
        for(Users user:allUsers){
            if((user.getEmail()).equals(email)){//Check if email already registered
                if((user.getPassword()).equals(password)){
                    valid = true;
                    break;
                }
            }
        }
        String reponse = "{'valid':"+valid+"}";
        try{
            JSONParser parser = new JSONParser();
            jsonResponse = (JSONObject) parser.parse(reponse);
        }
        catch(Exception e){
            System.out.println("Sorry we have an error!");
        }

        return jsonResponse;
    }
    public JSONObject getRegister1(Users newUser){

        String regPattern = "^[A-Za-z0-9\\.]+@[A-Za-z0-9\\.]+\\.[A-Za-z]{2,}[A-Za-z\\.]*";
        JSONObject jsonResponse = new JSONObject();
        Boolean validationPassed = true;
        String status = "PASSED";
        int invalidField = -1;


        //Check for email format
        if (Pattern.matches(regPattern, (newUser.getEmail())) == false){
            validationPassed = false;
            status = "The email entered is not valid";
            invalidField = 3;
        }
        //Check for invalid fields
        else if(validationPassed){
            if(((newUser.getFirstName()).length())< 2){
                validationPassed = false;
                status = "Please enter a valid first name";
                invalidField = 1;
            }
            else if((newUser.getLastName()).length() < 2){
                validationPassed = false;
                status = "Please enter a valid last name";
                invalidField = 2;
            }
            else if((newUser.getEmail()).length() == 0){
                validationPassed = false;
                status = "Please enter a valid email address";
                invalidField = 3;
            }
            
            else if(((newUser.getPassword()).length()) < 5){
                validationPassed = false;
                status = "The password needs to be longer than 4 characters";
                invalidField = 4;
            }
        }
        if(validationPassed){
            List<Users> allUsers = usersRepository.findAll();
            for(Users user:allUsers){
                if((user.getEmail()).equals(newUser.getEmail())){//Check if email already registered
                    validationPassed = false;
                    status = "An account is already registered with this email";
                    break;  
                }
            }
        }

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
