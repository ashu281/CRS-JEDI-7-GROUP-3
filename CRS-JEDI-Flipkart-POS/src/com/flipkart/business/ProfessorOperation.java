package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.List;

/**
 * @author Abhinav
 */
public class ProfessorOperation implements ProfessorInterface {
    /**
     * Method for Professor to grade the student on course
     * @param studentId
     * @param courseCode
     * @param grade
     */
    @Override
    public void addGrade(String studentId, String courseCode, String grade) {
        return;
    }

    /**
     * Method for viewing enrolled students in a course
     * @param profId
     * @param courseCode
     * @return
     */
    @Override
    public List<Student> viewEnrolledStudents(String profId, String courseCode) {
        return null;
    }

    /**
     * Method to view all courses taught by the professor
     * @param profId
     * @return
     */
    @Override
    public List<Course> getCourses(String profId) {
        return null;
    }
}
