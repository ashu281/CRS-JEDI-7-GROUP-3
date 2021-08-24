package com.flipkart.bean;

public class User {
    private String id;
    private String password;
    private String name;
    private String gender;
    private String address;

    public User(){

    }

    public User(String id, String name, String gender, String password, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.password = password;
        this.address = address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
