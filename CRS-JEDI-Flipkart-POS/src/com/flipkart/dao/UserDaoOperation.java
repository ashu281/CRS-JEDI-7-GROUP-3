package com.flipkart.dao;

import java.sql.Connection;

public class UserDaoOperation implements UserDaoInterface {
    @Override
    public void deleteUser(int userId) {

    }

    @Override
    public void updatePassword(int userId, String password) {

    }

    @Override
    public void updateName(int userId, String name) {

    }

    @Override
    public void updateGender(int userId, String gender) {

    }

    @Override
    public void updateAddress(int userId, String address) {

    }

    @Override
    public boolean verifyCredentials(int userId, String password) {
        return false;
    }

    @Override
    public String userType(int userId) {
        return null;
    }
//    Connection c
}
