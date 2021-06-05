package com.hlushkov.movieland.entity;

import com.hlushkov.movieland.common.Role;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nickname;
    private String email;
    private String password;
    private String salt;
    private Role role;


}
