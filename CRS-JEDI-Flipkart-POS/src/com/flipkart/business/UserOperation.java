package com.flipkart.business;

import com.flipkart.bean.User;

public class UserOperation implements  UserInterface{
    User[] users = new User[100];
    int totalUsers = 0;
    String loginUser =null;
    @Override
    public void createUser(String userId, String password, String name) {
        if(totalUsers == 100)
            return;
        User user = new User();
        user.setId(userId);
        user.setName(name);
        user.setPassword(password);
        users[totalUsers++] = user;
    }

    @Override
    public void updatePassword(String userId, String password) {
            for(int i = 0;i<totalUsers;i++){
                if(users[i].getId().equals(userId)){
                    users[i].setPassword(password);
                    break;
                }
            }
    }

    @Override
    public void updateName(String userId, String name) {
        for(int i = 0;i<totalUsers;i++){
            if(users[i].getId().equals(userId)){
                users[i].setName(name);
                break;
            }
        }
    }

    @Override
    public void deleteUser(String userId) {
        for(int i = 0;i<totalUsers;i++){
            if(users[i].getId().equals(userId)){
                users[i] = users[totalUsers-1];
                totalUsers--;
                break;
            }
        }
    }

    @Override
    public void login(String userId) {
        for(int i = 0;i<totalUsers;i++){
            if(users[i].getId().equals(userId)){
                loginUser = userId;
                break;
            }
        }
    }

    @Override
    public void logout() {
        if(loginUser != null)
            loginUser=null;

    }

    @Override
    public boolean isUserLogin(String userId) {
        return userId.equals(loginUser); 
    }
}
