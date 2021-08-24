package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;

/**
 *
 * @author JEDI-07
 * Interface for Professor Operations
 *
 */
public interface ProfessorInterface {
    public void addGrade(String studentId, String courseCode, String grade);
    public Student[] viewEnrolledStudents(int profId,String courseCode);
    public Course[] getCourses(int profId);
}
