package com.flipkart.business;

import com.flipkart.exception.UserNotFoundException;

/**
 * @author Sarthak
 */
public interface UserInterface {

    /**
     * Method to update password
     * @param userId
     * @param password
     */
    public void updatePassword(int userId, String password);

    /**
     * Method to verify credentials
     * @param userId
     * @param password
     * @return
     * @throws UserNotFoundException
     */
    public boolean verifyCredentials(int userId, String password) throws UserNotFoundException;

    /**
     * Method to return User Role
     * @param userId
     * @return
     */
    String userType(int userId);
}
