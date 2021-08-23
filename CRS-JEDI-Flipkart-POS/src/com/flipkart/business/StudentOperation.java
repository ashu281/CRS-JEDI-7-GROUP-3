package com.flipkart.business;

public class StudentOperation implements StudentInterface{
    @Override
    public void register(String studentID, String name, String password, String gender, String branch, int semester, String address) {

    }
    @Override
    public boolean isApproved(String userId) {
        return false;
    }

    @Override
    public String viewGradeCard(int studentID, int semester) {
        return null;
    }
}
