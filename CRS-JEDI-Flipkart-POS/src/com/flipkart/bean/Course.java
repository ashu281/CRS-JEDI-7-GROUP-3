package com.flipkart.bean;

/**
 *
 * @author JEDI-07
 * Class to store Course information
 *
 */


public class Course {

    private int courseID;
    private String courseName;
    private int instructorID;
    private int semester;
    private int seatsAvailable=10;

    public Course(int courseID, String courseName, int instructorID, Integer semester, Integer seatsAvailable) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.instructorID = instructorID;
        this.semester = semester;
        this.seatsAvailable = seatsAvailable;
    }

    /**
     * Method to get Course ID
     * @return Course ID
     */
    public int getCourseID() {
        return courseID;
    }


    /**
     * Method to set Course ID
     * @param courseID
     */
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    /**
     * Method to get Course Name
     * @return Course Name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Method to set Course Name
     * @param  Course Name
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    /**
     * Method to get semester No
     * @return semester
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Method to set semester
     * @param semester
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * Method to get instructor ID
     * @return instructor ID
     */
    public int getInstructorID() {
        return instructorID;
    }


    /**
     * Method to set instructor ID
     * @param  instructor ID
     */
    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }


    /**
     * Method to get available seats in a course
     * @return  available seats
     */
    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    /**
     * Method to set available seats in a course
     * @param  available seats
     */
    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }
}
