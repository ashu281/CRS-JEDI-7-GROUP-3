package com.flipkart.business;

/**
 * @author Pulkit
 */

public interface StudentInterface {

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
    void register(String studentID, String name, String password, String gender, String branch, int semester, String address);

    /**+
     * Method to view Student's grade card
     * @param studentID
     * @param semester
     * @return Grade Card
     */
    String viewGradeCard(int studentID, int semester);

    /**+
     * Method to check Approval status of Student
     * @param userId
     * @return Approval Status
     */
    boolean isApproved(String userId);
}
