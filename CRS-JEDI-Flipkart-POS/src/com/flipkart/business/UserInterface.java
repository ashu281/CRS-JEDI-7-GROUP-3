package com.flipkart.business;

/**
 * @author Sarthak
 */
public interface UserInterface {

    /**
     * Method to delete User
     * @param userId
     */
    public void deleteUser(String userId);

    /**
     * Method to update password
     * @param userId
     * @param password
     */
    public void updatePassword(String userId, String password);

    /**
     * Method to update name
     * @param userId
     * @param name
     */
    public void updateName(String userId,String name);

    /**
     * Method to update gender
     * @param userId
     * @param gender
     */
    public void updateGender(String userId,String gender);

    /**
     * Method to update address
     * @param userId
     * @param address
     */
    public void updateAddress(String userId,String address);

    /**
     * Method to verify Credentials
     * @param userId
     * @param password
     * @return
     */
    public boolean verifyCredentials(String userId, String password);

    /**
     * Method to return User Role
     * @param userId
     * @return
     */
    String userType(String userId);
}
