package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Notification;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;

import java.util.List;

/**
 * @author Pulkit
 */

public class StudentOperation implements StudentInterface{

    /**+
     * Method to register Student for courses
     * @param name
     * @param password
     * @param gender
     * @param branch
     * @param semester
     * @param address
     */
    @Override
    public void register(String name, String password, String gender, String branch, int semester, String address) {
        StudentDaoInterface studentDao = new StudentDaoOperation();
        studentDao.register(name, password, gender, branch, semester, address);
    }

    /**+
     * Method to check Approval status of Student
     * @param studentId
     * @return Approval Status
     */
    @Override
    public boolean isApproved(int studentId) {
        StudentDaoInterface studentDao = new StudentDaoOperation();
        return studentDao.isApproved(studentId);
    }

    /**
     * Make Payment
     *
     * @param studentID
     * @param semester
     */
    @Override
    public void makePayment(int studentID, int semester) {
        StudentDaoInterface studentDao = new StudentDaoOperation();
        Notification paymentNotification = studentDao.makePayment(studentID, semester);

        System.out.println("Notification: "+ paymentNotification.getNotificationMessage());
    }

    /**
     * Method to get Registered Courses
     *
     * @param studentID
     * @return
     */
    @Override
    public List<Course> getRegisteredCourses(int studentID) {
        StudentDaoInterface studentDao = new StudentDaoOperation();
        return studentDao.getRegisteredCourses(studentID);
    }

    /**
     * Method to get available courses
     *
     * @param semester
     * @return
     */
    @Override
    public List<Course> getCourses(int semester) {
        StudentDaoInterface studentDao = new StudentDaoOperation();
        return studentDao.getCourses(semester);
    }

    /**
     * Method to add course
     *
     * @param courseId
     * @param studentId
     */
    @Override
    public void addCourse(int courseId, int studentId) {
        StudentDaoInterface studentDao = new StudentDaoOperation();
        studentDao.addCourse(studentId, courseId);
    }

    /**
     * Method to drop course
     *
     * @param courseId
     * @param studentId
     */
    @Override
    public void dropCourse(int courseId, int studentId) {
        StudentDaoInterface studentDao = new StudentDaoOperation();
        studentDao.dropCourse(studentId, courseId);
    }



    /**+
     * Method to view Student's grade card
     * @param studentID
     * @param semester
     * @return grade card
     */
    @Override
    public Grade viewGradeCard(int studentID, int semester) {
        StudentDaoInterface studentDao = new StudentDaoOperation();
        return studentDao.viewGradeCard(studentID, semester);
    }

    /**+
     *
     * @param studentId
     */
    @Override
    public void registerForCourses(int studentId) {
        //
        return;
    }
}
