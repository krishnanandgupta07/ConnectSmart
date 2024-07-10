package com.connectSmart.cm.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;


@Entity(name="user")
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private String userId;
    @Column(name="user_name",nullable=false)
    private String name;
    @Column(unique =true,nullable = false)
    private String email;
    private String password;
    @Column(length = 5000)
    private String about;
    @Column(length = 5000)
    private String profilePic;
    private String phoneNumber;
    //information
    private boolean enabled=false;
    private boolean emailVerified=false;
    private boolean phoneVerified=false;

    //self,Google,Facebook,Twitter,LinkedIn,Github
    private Providers provider=Providers.SELF;
    private String providerUserId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval=true)
    private List<Contact> contacts=new ArrayList<>();

    


    

}
