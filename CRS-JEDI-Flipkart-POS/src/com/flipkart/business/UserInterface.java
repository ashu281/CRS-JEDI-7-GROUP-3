package com.flipkart.business;

public interface UserInterface {
    public void createUser(String userId,String password,String name);
    public void updatePassword(String userId,String password);
    public void updateName(String userId,String name);
    public void deleteUser(String userId);
    public void login(String userId);
    public void logout();
    public boolean isUserLogin(String userId);

}
