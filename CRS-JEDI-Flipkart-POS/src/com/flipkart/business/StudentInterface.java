package com.flipkart.business;

import com.flipkart.bean.Course;

import java.util.List;

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
    String viewGradeCard(String studentID, int semester);

    /**+
     * Method to check Approval status of Student
     * @param userId
     * @return Approval Status
     */
    boolean isApproved(String userId);

    /**
     * Method to make Payment
     * @param studentId
     * @param semester
     */
    void makePayment(String studentId, int semester);

    /**
     * Method to get Registered Courses
     * @param studentId
     * @return
     */
    List<Course> getRegisteredCourses(String studentId);

    /**
     * Method to get available courses
     * @param studentId
     * @return
     */
    List<Course> getCourses(String studentId);

    /**
     * Method to add course
     * @param courseId
     */
    void addCourse(String courseId);

    /**
     * Method to drop course
     * @param courseId
     */
    void dropCourse(String courseId);

    /**
     * Method to register for selected courses
     * @param studentId
     */
    void registerForCourses(String studentId);
}
