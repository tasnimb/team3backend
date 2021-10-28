package com.bbtutorials.users.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;




@Entity(name = "Users")
//@Data
@Getter
public class Users {
    public Users(String FIRSTNAME, String LASTNAME, String EMAIL, String PASSWORD){
        this.FIRSTNAME = FIRSTNAME;
        this.LASTNAME = LASTNAME;
        this.EMAIL = EMAIL;
        this.PASSWORD = PASSWORD;
    }
    public Users(){
    }


	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    @NotNull
    private String FIRSTNAME;
    
    @Column
    @NotNull
    private String LASTNAME;
    
    @Column
    @NotNull
    private String EMAIL;

    @Column
    @NotNull
    private String PASSWORD;

    public void setId(Integer id){
        this.id = id;
    }
    public String getEmail(){
        return EMAIL;
    }

}
