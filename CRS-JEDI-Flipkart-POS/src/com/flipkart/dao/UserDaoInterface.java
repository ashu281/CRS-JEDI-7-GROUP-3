package com.flipkart.dao;

public interface UserDaoInterface {
    /**
     * Method to delete User
     * @param userId
     */
    public void deleteUser(int userId);

    /**
     * Method to update password
     * @param userId
     * @param password
     */
    public void updatePassword(int userId, String password);

    /**
     * Method to update name
     * @param userId
     * @param name
     */
    public void updateName(int userId,String name);

    /**
     * Method to update gender
     * @param userId
     * @param gender
     */
    public void updateGender(int userId,String gender);

    /**
     * Method to update address
     * @param userId
     * @param address
     */
    public void updateAddress(int userId,String address);

    /**
     * Method to verify Credentials
     * @param userId
     * @param password
     * @return
     */
    public boolean verifyCredentials(int userId, String password);

    /**
     * Method to return User Role
     * @param userId
     * @return
     */
    String userType(int userId);
}
