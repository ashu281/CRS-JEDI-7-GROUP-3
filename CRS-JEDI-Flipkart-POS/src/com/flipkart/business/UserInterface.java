package com.flipkart.business;

public interface UserInterface {

    public void deleteUser(String userId);
    public void updatePassword(String userId, String password);
    public void updateName(String userId,String name);
    public void updateGender(String userId,String gender);
    public void updateAddress(String userId,String address);
    public boolean verifyCredentials(String userId, String password);
    String userType(String userId);
}
