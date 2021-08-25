package com.flipkart.business;

import com.flipkart.bean.Course;

import java.util.List;

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

    /**
     * Make Payment
     *
     * @param studentId
     * @param semester
     */
    @Override
    public void makePayment(String studentId, int semester) {

    }

    /**
     * Method to get Registered Courses
     *
     * @param studentId
     * @return
     */
    @Override
    public List<Course> getRegisteredCourses(String studentId) {
        return null;
    }

    /**
     * Method to get available courses
     *
     * @param studentId
     * @return
     */
    @Override
    public List<Course> getCourses(String studentId) {
        return null;
    }

    /**
     * Method to add course
     *
     * @param courseId
     */
    @Override
    public void addCourse(String courseId) {

    }

    /**
     * Method to drop course
     *
     * @param courseId
     */
    @Override
    public void dropCourse(String courseId) {

    }

    /**
     * Method to register for selected courses
     *
     * @param studentId
     */
    @Override
    public void registerForCourses(String studentId) {

    }

    /**+
     * Method to view Student's grade card
     * @param studentID
     * @param semester
     * @return grade card
     */
    @Override
    public String viewGradeCard(String studentID, int semester) {
        return null;
    }


}
