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
    public void register(int studentID, String name, String password, String gender, String branch, int semester, String address) {

    }

    /**+
     * Method to check Approval status of Student
     * @param userId
     * @return Approval Status
     */
    @Override
    public boolean isApproved(int userId) {
        return false;
    }

    /**
     * Make Payment
     *
     * @param studentId
     * @param semester
     */
    @Override
    public void makePayment(int studentID, int semester) {

    }

    /**
     * Method to get Registered Courses
     *
     * @param studentId
     * @return
     */
    @Override
    public List<Course> getRegisteredCourses(int studentID) {
        return null;
    }

    /**
     * Method to get available courses
     *
     * @param studentId
     * @return
     */
    @Override
    public List<Course> getCourses(int studentID) {
        return null;
    }

    /**
     * Method to add course
     *
     * @param courseId
     */
    @Override
    public void addCourse(int courseId) {

    }

    /**
     * Method to drop course
     *
     * @param courseId
     */
    @Override
    public void dropCourse(int courseId) {

    }

    /**
     * Method to register for selected courses
     *
     * @param studentId
     */
    @Override
    public void registerForCourses(int studentID) {

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
