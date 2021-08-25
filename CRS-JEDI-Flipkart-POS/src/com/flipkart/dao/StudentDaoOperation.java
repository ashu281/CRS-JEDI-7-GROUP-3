package com.flipkart.dao;

import com.flipkart.bean.Course;

import java.util.List;

public class StudentDaoOperation implements StudentDaoInterface{
    @Override
    public void register(int studentId, String name, String password, String gender, String branch, int semester, String address) {

    }

    @Override
    public String viewGradeCard(int studentId, int semester) {
        return null;
    }

    @Override
    public boolean isApproved(int userId) {
        return false;
    }

    @Override
    public void makePayment(int studentId, int semester) {

    }

    @Override
    public List<Course> getRegisteredCourses(int studentId) {
        return null;
    }

    @Override
    public List<Course> getCourses(int studentId) {
        return null;
    }

    @Override
    public void addCourse(int courseId) {

    }

    @Override
    public void dropCourse(int courseId) {

    }

    @Override
    public void registerForCourses(int studentId) {

    }
}
