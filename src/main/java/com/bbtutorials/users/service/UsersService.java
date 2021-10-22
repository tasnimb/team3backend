package com.bbtutorials.users.service;

import java.util.List;
import java.util.Random;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.bbtutorials.users.entity.Users;
import com.bbtutorials.users.repository.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
public class UsersService {
	
	private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getUsers() {
        return usersRepository.findAll();
    }
    
    public Users saveUser(Users users) {
    	users.setId(new Random().nextInt());
    	return usersRepository.save(users);
    }

}
