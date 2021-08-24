package com.flipkart.bean;

import java.util.HashMap;

public class Grade {
    String courseName;
    String studentID;
    int semester;
    float CGPA;
    HashMap<String, Integer> grades;
    /*courseCode to gradePoint*/

    /**
     * Method to get Courses name
     *
     * @return Course Name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Method to set Courses name
     *
     * @param courseName
     */

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Method to get studentId
     *
     * @return student Id
     */

    public String getStudentID() {
        return studentID;
    }

    /**
     * Method to set Courses name
     *
     * @param studentID
     */

    public void setStudentId(String studentID) {
        this.studentID = studentID;
    }

    /**
     * Method to get semester number
     *
     * @return semester number
     */

    public int getSemester() {
        return semester;
    }

    /**
     * Method to set semester number
     *
     * @param semester : semester number
     */

    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * Method to get CGPA
     *
     * @return CGPA
     */

    public float getCGPA() {
        return CGPA;
    }

    /**
     * Method to set CGPA
     *
     * @param CGPA
     */
    public void setCGPA(float CGPA) {
        this.CGPA = CGPA;
    }

    /**
     * Method to get Grades
     *
     * @return Hashmap with CourseID as key and Grade point as value
     */

    public HashMap<String, Integer> getGrades() {
        return grades;
    }

    /**
     * Method to set Grades
     *
     * @param grades : Hashmap with CourseID as key and Grade point as value
     */

    public void setGrades(HashMap<String, Integer> grades) {
        this.grades = grades;
    }
}
