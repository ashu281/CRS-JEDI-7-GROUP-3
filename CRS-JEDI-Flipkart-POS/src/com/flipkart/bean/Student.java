package com.flipkart.bean;

public class Student extends User{

    private int studentId;
    private String branch;
    private int semester;
    private boolean isApproved = false;

    public Student(String userId, String name, String gender, String password,String branch, int studentId, int semester) {
        super(userId, name, gender, password);
        this.studentId = studentId;
        this.branch = branch;
        this.semester = semester;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

}
