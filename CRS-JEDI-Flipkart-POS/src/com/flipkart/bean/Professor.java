package com.flipkart.bean;

public class Professor extends User{

    private String designation;
    private String department;

    public Professor(String userId, String name, String gender, String password,String branch, int studentId, int semester) {
        super(userId, name, gender, password, address);
        this.designation = designation;
        this.department = department;
    }
    public String getDesignation() {
        return designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
