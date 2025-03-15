package com.barsat.touch_grass.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@Data
public class TheUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer masterId;

    @Column(nullable = false , unique = true)  //username can't be null and should be unique
    private String username;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    @Column(length = 10000)
    private String avatarUrl;

    private String bio ;

    private boolean isEnabled;

    private boolean emailVerified;


    public TheUser(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


    public TheUser() {

    }

    @OneToMany(mappedBy = "theUser")
    private List<challengesEntity> challengesEntity;


    //keep adding more fields if needed.
}
