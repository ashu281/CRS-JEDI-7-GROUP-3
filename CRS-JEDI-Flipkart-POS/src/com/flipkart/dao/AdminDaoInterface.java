package com.flipkart.dao;

import com.flipkart.exception.StudentNotFoundForApprovalException;

public interface AdminDaoInterface {

    /**
     * Method to add a new professor
     *
     */
    public void addProfessor(String name, String gender, String password, String address, String designation, String department);

    /**
     * Method to approve a student
     */
    public void approveStudent(int studentId) throws StudentNotFoundForApprovalException;

    /**
     * Method to add courses in the catalog
     */
    public void addCourse(String courseName, int instructorID, int semester);

    /**
     * Method to delete courses in the catalog
     */
    public void deleteCourse(int courseID);

    /**
     * Method to approve student's course
     * @param studentId
     * @param courseId
     */
    void approveCourse(int studentId, int courseId);
}
