package com.flipkart.business;


import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.AdminDaoOperation;

/**
 * @author JEDI-07
 * Implementations of Admin Operations
 */


public class AdminOperation implements AdminInterface {
    /**
     *
     * Method to add a new professor
     * @param name
     * @param gender
     * @param password
     * @param address
     * @param designation
     * @param department
     */
    @Override
    public void addProfessor(String name, String gender, String password, String address, String designation, String department) {
        AdminDaoInterface adminDaoInterface = new AdminDaoOperation();
        adminDaoInterface.addProfessor(name,gender,password,address,designation,department);
    }

    /**+
     * Method to approve registration of a Student
     * @param studentId
     */
    @Override
    public void approveStudent(int studentId) {
        AdminDaoInterface adminDaoInterface = new AdminDaoOperation();
        adminDaoInterface.approveStudent(studentId);
    }
    
    /**
     * Method to add courses in the catalog
     *  @param courseName
     * @param instructorID
     * @param semester
     */
    @Override
    public void addCourse(String courseName, int instructorID, Integer semester) {
        AdminDaoInterface adminDaoInterface = new AdminDaoOperation();
        adminDaoInterface.addCourse(courseName,instructorID,semester);
    }
    
    /**
     * Method to delete courses in the catalog
     *
     * @param courseID
     */
    @Override
    public void deleteCourse(int courseID) {
        AdminDaoInterface adminDaoInterface = new AdminDaoOperation();
        adminDaoInterface.deleteCourse(courseID);
    }

    @Override
    public void generateGradeCard() {

    }

    /**
     * Method to approve student's selected course
     *
     * @param studentId
     * @param courseId
     */
    @Override
    public void approveCourse(int studentId, int courseId) {
        AdminDaoInterface adminDaoInterface = new AdminDaoOperation();
        adminDaoInterface.approveCourse(studentId,courseId);
    }
}
