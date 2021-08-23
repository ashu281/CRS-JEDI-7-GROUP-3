package com.flipkart.business;

public class UserOperation implements UserInterface {

    @Override
    public boolean updatePassword(String userId, String password) {

        return false;
    }

    @Override
    public void updateName(String userId, String name) {

    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public void login(String userId) {

    }

    @Override
    public void logout() {

    }

    @Override
    public boolean isUserLogin(String userId) {
        return false;
    }

    @Override
    public boolean updateGender(String gender) {
        return false;
    }

    @Override
    public boolean verifyCredentials(String userId, String password) {
        return false;
    }

    @Override
    public String userType(String userId) {
        return null;
    }
}
