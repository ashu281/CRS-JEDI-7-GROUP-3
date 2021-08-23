package com.flipkart.business;

public interface StudentInterface {

    void register(int studentID, String branch, int semester);
    String viewGradeCard(int studentID, int semester);

}
