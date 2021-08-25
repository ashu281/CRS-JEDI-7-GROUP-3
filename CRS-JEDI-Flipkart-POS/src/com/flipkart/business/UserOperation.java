package com.flipkart.business;

/**
 * @author Sarthak
 */
public class UserOperation implements UserInterface {


    /**
     * Method to delete User
     * @param userId
     */
    @Override
    public void deleteUser(String userId) {
        DummyDB.userList.remove(userId);
    }

    /**
     * Method to update password
     * @param userId
     * @param password
     */
    @Override
    public void updatePassword(String userId, String password) {
        DummyDB.userList.get(userId).setPassword(password);
    }

    /**
     * Method to update name
     * @param userId
     * @param name
     */
    @Override
    public void updateName(String userId, String name) {
            DummyDB.userList.get(userId).setName(name);
    }

    /**
     * Method to update gender
     * @param userId
     * @param gender
     */
    @Override
    public void updateGender(String userId, String gender) {
        DummyDB.userList.get(userId).setGender(gender);
    }

    /**
     * Method to update address
     * @param userId
     * @param address
     */
    @Override
    public void updateAddress(String userId, String address) {
        DummyDB.userList.get(userId).setAddress(address);
    }

    /**
     * Method to verify Credentials
     * @param userId
     * @param password
     * @return
     */
    @Override
    public boolean verifyCredentials(String userId, String password) {
        return DummyDB.userList.containsKey(userId) && DummyDB.userList.get(userId).getPassword().equals(password);
    }

    /**
     * Method to return User Role
     * @param userId
     * @return
     */
    @Override
    public String userType(String userId) {
        return DummyDB.userList.get(userId).getRole();
    }
}
