package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.List;

/**
 *
 * @author JEDI-07
 * Interface for Professor Operations
 *
 */
public interface ProfessorInterface {
    /**
     * Method for Professor to grade the student on course
     * @param studentId
     * @param courseCode
     * @param grade
     */
    public void addGrade(int studentId, int courseCode, String grade);

    /**
     * Method for viewing enrolled students in a course
     * @param profId
     * @param courseCode
     * @return
     */
    public List<Student> viewEnrolledStudents(int profId, int courseCode);

    /**
     * Method to view all courses taught by the professor
     * @param profId
     * @return
     */
    public List<Course> getCourses(int profId);
}
