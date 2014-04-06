package com.github.diseng.model;

import javax.persistence.*;

/**
 * Created by dengqinglin on 14-4-4.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 25,unique = true)
    private String username;

    @Column(nullable = false,length = 32)
    private String password;

    @Column(nullable = false,length = 64)
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
