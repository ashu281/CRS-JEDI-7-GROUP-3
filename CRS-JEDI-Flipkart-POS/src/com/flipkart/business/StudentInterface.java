package com.flipkart.business;

public interface StudentInterface {

    void register(String studentID, String name, String password, String gender, String branch, int semester, String address);

    String viewGradeCard(int studentID, int semester);

    boolean isApproved(String userId);
}
