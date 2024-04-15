package com.demowebshop.models;

public class User {
    private String email;
    private String password;
    private String firstname;
    private String secondname;

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public User setSecondname(String secondname) {
        this.secondname = secondname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSecondname() {
        return secondname;
    }
}
