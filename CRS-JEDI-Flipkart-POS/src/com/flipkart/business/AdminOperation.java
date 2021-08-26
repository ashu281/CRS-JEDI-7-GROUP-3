package com.flipkart.business;


import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.AdminDaoOperation;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.StudentNotFoundForApprovalException;
import org.apache.log4j.Logger;

/**
 * @author JEDI-07
 * Implementations of Admin Operations
 */


public class AdminOperation implements AdminInterface {
    private static Logger logger = Logger.getLogger(AdminOperation.class);
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
//        logger.info("addProfessor()");
//        logger.debug(name+" "+gender+" "+address);
        AdminDaoInterface adminDaoInterface = new AdminDaoOperation();
        adminDaoInterface.addProfessor(name,gender,password,address,designation,department);
    }

    /**+
     * Method to approve registration of a Student
     * @param studentId
     */
    @Override
    public void approveStudent(int studentId)throws StudentNotFoundForApprovalException {
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
    public void deleteCourse(int courseID) throws CourseNotFoundException {
        AdminDaoInterface adminDaoInterface = new AdminDaoOperation();
        adminDaoInterface.deleteCourse(courseID);
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