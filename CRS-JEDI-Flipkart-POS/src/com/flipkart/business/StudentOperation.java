package com.flipkart.business;

/**
 * @author Pulkit
 */

public class StudentOperation implements StudentInterface{

    /**+
     * Method to register Student for courses
     * @param studentID
     * @param name
     * @param password
     * @param gender
     * @param branch
     * @param semester
     * @param address
     */
    @Override
    public void register(String studentID, String name, String password, String gender, String branch, int semester, String address) {

    }

    /**+
     * Method to check Approval status of Student
     * @param userId
     * @return Approval Status
     */
    @Override
    public boolean isApproved(String userId) {
        return false;
    }

    /**+
     * Method to view Student's grade card
     * @param studentID
     * @param semester
     * @return grade card
     */
    @Override
    public String viewGradeCard(int studentID, int semester) {
        return null;
    }
}
