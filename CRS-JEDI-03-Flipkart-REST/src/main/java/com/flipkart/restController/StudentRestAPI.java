package com.flipkart.restController;


import com.flipkart.bean.Grade;

import com.flipkart.business.GradecardInterface;
import com.flipkart.business.GradecardOperation;
import com.flipkart.business.StudentInterface;
import com.flipkart.business.StudentOperation;

import com.flipkart.exception.CourseLimitExceedException;
import com.flipkart.utils.UserAuth;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

/**
 * @author Sarthak
 */
@Path("/student")
public class StudentRestAPI {

    StudentInterface studentInterface = new StudentOperation();
    /**
     * Method to Make payment for the semester
     * @param
     */
    @POST
    @Path("/makePayment")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String makePayment(Map<String,String> params,@HeaderParam("authKey") String authKey) {
        if(UserAuth.isStudentLogin(authKey) == null){
            return "Access Denied";
        }
        studentInterface.makePayment(UserAuth.isStudentLogin(authKey),Integer.parseInt(params.get("semester")));
        return  "Payment Successful";

    }

    /**
     * Method to View Grade card for the semester
     * @param
     */
    @POST
    @Path("/viewGradeCard")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object  viewGradeCard(Map<String,String> params,@HeaderParam("authKey") String authKey) {
        if(UserAuth.isStudentLogin(authKey) == null){
            return "Access Denied";
        }
        Grade gradeCard = studentInterface.viewGradeCard(Integer.parseInt(params.get("studentId")),Integer.parseInt(params.get("semester")));
        GradecardInterface gradecardInterface = new GradecardOperation();
        gradecardInterface.calculateCGPA(gradeCard);
        HashMap <String, Double> grades = gradeCard.getGrades();
        if(grades.size()>=6) {
            return gradeCard;
        } else {
            return "Semester not yet completed";
        }
    }

    /**
     * Method to View enrolled courses
     * @param
     */

    @GET
    @Path("/viewRegisteredCourses")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object viewRegisteredCourse(@HeaderParam("authKey") String authKey) {

        if(UserAuth.isStudentLogin(authKey) == null){
            return "Access Denied";
        }
        return studentInterface.getRegisteredCourses(UserAuth.isStudentLogin(authKey));

    }

    /**
     * Method to View available courses
     * @param
     */

    @POST
    @Path("/viewCourse")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object viewCourse(Map<String,String> params,@HeaderParam("authKey") String authKey) {
        if(UserAuth.isStudentLogin(authKey) == null){
            return "Access Denied";
        }
        return studentInterface.getCourses(Integer.parseInt(params.get("semester")));
    }

    /**
     * Method to Add a course
     * @param
     */

    @POST
    @Path("/addCourse")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addCourse(Map<String,String> params,@HeaderParam("authKey") String authKey) {
        if(UserAuth.isStudentLogin(authKey) == null){
            return "Access Denied";
        }
        try{
            studentInterface.addCourse(Integer.parseInt(params.get("courseId")), UserAuth.isStudentLogin(authKey));
            return "Course Added";
        }catch (CourseLimitExceedException ex){
            return ex.getMessage();
        }

    }

    /**
     * Method to Drop a course
     * @param
     */

    @POST
    @Path("/dropCourse")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String dropCourse(Map<String,String> params,@HeaderParam("authKey") String authKey) {
        if(UserAuth.isStudentLogin(authKey) == null){
            return "Access Denied";
        }
        studentInterface.dropCourse(Integer.parseInt(params.get("courseId")), UserAuth.isStudentLogin(authKey));
        return "Course Deleted!";



    }

    /**
     * Method to Register for selected courses
     * @param studentId
     */
    private void registerCourses(int studentId) {
        studentInterface.registerForCourses(studentId);

    }
}
