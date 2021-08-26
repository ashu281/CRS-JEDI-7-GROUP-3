package com.flipkart.business;

import com.flipkart.dao.UserDaoInterface;
import com.flipkart.dao.UserDaoOperation;
import com.flipkart.exception.UserNotFoundException;
import org.apache.log4j.Logger;

/**
 * @author Sarthak
 */
public class UserOperation implements UserInterface {

    UserDaoInterface userDaoInterface = new UserDaoOperation();
    private static Logger logger = Logger.getLogger(AdminOperation.class);

    /**
     * Method to update password
     * @param userId
     * @param password
     */
    @Override
    public void updatePassword(int userId, String password) {
        logger.info("Updating password...");
        userDaoInterface.updatePassword(userId,password);
    }

    /**
     * Method to verify Credentials
     * @param userId
     * @param password
     * @return
     */
    @Override
    public boolean verifyCredentials(int userId, String password) throws UserNotFoundException {
        logger.info("Verifying Credentials...");
        return userDaoInterface.verifyCredentials(userId,password);
    }

    /**
     * Method to return User Role
     * @param userId
     * @return
     */
    @Override
    public String userType(int userId) {
        logger.info("Retrieving user type");
        return userDaoInterface.userType(userId);
    }
}
