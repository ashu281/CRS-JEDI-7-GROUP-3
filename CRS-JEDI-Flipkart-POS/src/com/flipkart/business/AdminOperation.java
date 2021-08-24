package com.flipkart.business;


import com.flipkart.bean.Student;
import com.flipkart.bean.Professor;
import com.flipkart.business.DummyDB;


/**
 * @author JEDI-07
 * Implementations of Admin Operations
 */


public class AdminOperation implements AdminInterface {
    @Override
    public void addProfessor() {

    }

    @Override
    public void approveStudents() {

    }

    @Override
    public void addCourse(Course course) {
        DummyDB.courseList.put(course.courseID, course);
    }

    @Override
    public void deleteCourse(String courseID;) {
        DummyDB.courseList.remove(courseID);
    }

    @Override
    public void generateGradeCard() {

    }
}
