package com.flipkart.dao;

public interface AdminDaoInterface {

    /**
     * Method to add a new professor
     *
     */
    public void addProfessor(String name, String gender, String password, String address, String designation, String department);

    /**
     * Method to approve a student
     */
    public void approveStudent(int studentId);

    /**
     * Method to add courses in the catalog
     */
    public void addCourse(String courseName, int instructorID, int semester);

    /**
     * Method to delete courses in the catalog
     */
    public void deleteCourse(int courseID);


}
