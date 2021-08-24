package com.flipkart.business;

public class UserOperation implements UserInterface {


    @Override
    public void deleteUser(String userId) {
        DummyDB.userList.remove(userId);
    }

    @Override
    public void updatePassword(String userId, String password) {
        DummyDB.userList.get(userId).setPassword(password);
    }

    @Override
    public void updateName(String userId, String name) {
            DummyDB.userList.get(userId).setName(name);
    }

    @Override
    public void updateGender(String userId, String gender) {
        DummyDB.userList.get(userId).setGender(gender);
    }

    @Override
    public void updateAddress(String userId, String address) {
        DummyDB.userList.get(userId).setAddress(address);
    }

    @Override
    public boolean verifyCredentials(String userId, String password) {
        return DummyDB.userList.containsKey(userId) && DummyDB.userList.get(userId).getPassword().equals(password);
    }

    @Override
    public String userType(String userId) {
        return DummyDB.userList.get(userId).getRole();
    }
}
