package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

public class ProfessorOperation implements ProfessorInterface {
    @Override
    public void addGrade(String studentId, String courseCode, String grade) {

    }

    @Override
    public Student[] viewEnrolledStudents(int profId, String courseCode) {
        return new Student[0];
    }

    @Override
    public Course[] getCourses(int profId) {
        return new Course[0];
    }
}
