package com.flipkart.dao;

import com.flipkart.bean.Course;

import java.util.List;

public interface StudentDaoInterface {
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
    void register(int studentId, String name, String password, String gender, String branch, int semester, String address);

    /**+
     * Method to view Student's grade card
     * @param studentID
     * @param semester
     * @return Grade Card
     */
    String viewGradeCard(int studentId, int semester);

    /**+
     * Method to check Approval status of Student
     * @param userId
     * @return Approval Status
     */
    boolean isApproved(int userId);

    /**
     * Method to make Payment
     * @param studentId
     * @param semester
     */
    void makePayment(int studentId, int semester);

    /**
     * Method to get Registered Courses
     * @param studentId
     * @return
     */
    List<Course> getRegisteredCourses(int studentId);

    /**
     * Method to get available courses
     * @param studentId
     * @return
     */
    List<Course> getCourses(int studentId);

    /**
     * Method to add course
     * @param courseId
     */
    void addCourse(int courseId);

    /**
     * Method to drop course
     * @param courseId
     */
    void dropCourse(int courseId);

    /**
     * Method to register for selected courses
     * @param studentId
     */
    void registerForCourses(int studentId);
}
