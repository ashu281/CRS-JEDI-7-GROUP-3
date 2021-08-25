package com.flipkart.business;

import com.flipkart.dao.UserDaoInterface;
import com.flipkart.dao.UserDaoOperation;

/**
 * @author Sarthak
 */
public class UserOperation implements UserInterface {

    UserDaoInterface userDaoInterface = new UserDaoOperation();


    /**
     * Method to update password
     * @param userId
     * @param password
     */
    @Override
    public void updatePassword(int userId, String password) {

        userDaoInterface.updatePassword(userId,password);

    }

    /**
     * Method to verify Credentials
     * @param userId
     * @param password
     * @return
     */
    @Override
    public boolean verifyCredentials(int userId, String password) {
        return userDaoInterface.verifyCredentials(userId,password);
//        return DummyDB.userList.containsKey(userId) && DummyDB.userList.get(userId).getPassword().equals(password);
    }

    /**
     * Method to return User Role
     * @param userId
     * @return
     */
    @Override
    public String userType(int userId) {
        return userDaoInterface.userType(userId);
    }
}
