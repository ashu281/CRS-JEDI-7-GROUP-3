package com.flipkart.bean;

public class Professor extends User{

    private String designation;
    private String department;
    private String profId;

    public Professor(String userId, String name, String gender, String password,String address,String designation,String department, String profId) {
        super(userId, name, gender, password, address);
        this.designation = designation;
        this.department = department;
        this.profId = profId;
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
