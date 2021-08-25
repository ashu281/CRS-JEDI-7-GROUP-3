package com.flipkart.dao;

public class TestClass {
    public static void main(String[] args) {
        UserDaoInterface userDaoInterface = new UserDaoOperation();
        System.out.println(userDaoInterface.verifyCredentials(1,"abcd"));
    }
}
