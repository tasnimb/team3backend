package com.bbtutorials.users.entity;
import lombok.Data;
import javax.persistence.*;



@Entity
@Data
public class Shows{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String country;

    @Column(nullable=false)
    private String city;

    @Column(nullable=false)
    private String latitude;

    @Column(nullable=false)
    private String longitude;


}