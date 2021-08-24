package com.flipkart.bean;

/**
 *
 * @author JEDI-07
 * Class to store Course information
 *
 */


public class Course {

    private String courseID;
    private String courseName;
    private String instructorID;
    private Integer semester;
    private Integer seatsAvailable=10;



    /**
     * Method to get Course ID
     * @return Course ID
     */
    public String getCourseID() {
        return courseID;
    }


    /**
     * Method to set Course ID
     * @param courseID
     */
    public void setCourseID(String courseID) {
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
    public Integer getSemester() {
        return semester;
    }

    /**
     * Method to set semester
     * @param semester
     */
    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    /**
     * Method to get instructor ID
     * @return instructor ID
     */
    public String getInstructorID() {
        return instructorID;
    }


    /**
     * Method to set instructor ID
     * @param  instructor ID
     */
    public void setInstructorID(String instructorID) {
        this.instructorID = instructorID;
    }


    /**
     * Method to get available seats in a course
     * @return  available seats
     */
    public Integer getSeatsAvailable() {
        return seatsAvailable;
    }

    /**
     * Method to set available seats in a course
     * @param  available seats
     */
    public void setSeatsAvailable(Integer seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }
}
