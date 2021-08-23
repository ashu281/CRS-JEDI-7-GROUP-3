package com.flipkart.bean;

import java.util.HashMap;

import com.flipkart.bean.Course;

public class Grade {
    String name;
    int studentId;
    int semester;
    float CGPA;
    HashMap<String, Integer> grades;
    /*courseCode to gradePoint*/


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public float getCGPA() {
        return CGPA;
    }

    public void setCGPA(float CGPA) {
        this.CGPA = CGPA;
    }

    public HashMap<String, Integer> getGrades() {
        return grades;
    }

    public void setGrades(HashMap<String, Integer> grades) {
        this.grades = grades;
    }
}
