package com.flipkart.restController;

import com.flipkart.business.AdminInterface;
import com.flipkart.business.AdminOperation;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;


/**
 * @author Sarthak
 */

@Path("/admin")
public class AdminRestAPI {


    AdminInterface adminOperation = new AdminOperation();
    /**
     * Method to approve student's course
     */

    @POST
    @Path("/approveCourse")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String approveCourse(Map<String,String> params, @HeaderParam("authKey") String authKey) {
        if(UserAuth.isAdminLogin(authKey) == null){
            return "Access Denied";
        }
        adminOperation.approveCourse(Integer.parseInt(params.get("studentId")),Integer.parseInt(params.get("courseId")));
        return "Course Approved Successfully!";
    }

    /**
     * Method to Add a professor into the system
     */

    @POST
    @Path("/addProfessor")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addProfessor(Map<String,String> params, @HeaderParam("authKey") String authKey) {
        if(UserAuth.isAdminLogin(authKey) == null){
            return "Access Denied";
        }
        adminOperation.addProfessor(params.get("name"),params.get("gender"),params.get("password"),
                                    params.get("address"),params.get("designation"),params.get("department"));
        return "Professor "+params.get("name")+" Added!";

    }

    /**
     * Method to Approve Student Registration
     */
    @POST
    @Path("/approveStudent")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String approveStudent(Map<String,String> params, @HeaderParam("authKey") String authKey) {

        if(UserAuth.isAdminLogin(authKey) == null){
            return "Access Denied";
        }

        adminOperation.approveStudent(Integer.parseInt(params.get("studentId")));
        return "Student "+params.get("studentId")+" Approved!";


    }

    /**
     * Method to Delete course from catalogue
     */

    @DELETE
    @Path("/course")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteCourse(Map<String,String> params, @HeaderParam("authKey") String authKey) {
        if(UserAuth.isAdminLogin(authKey) == null){
            return "Access Denied";
        }
        adminOperation.deleteCourse(Integer.parseInt(params.get("courseId")));
        return "Course "+params.get("courseId")+" deleted!";

    }

    /**
     * Method to Add course to catalogue
     */
    @POST
    @Path("/course")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addCourse(Map<String,String> params, @HeaderParam("authKey") String authKey) {
        if(UserAuth.isAdminLogin(authKey) == null){
            return "Access Denied";
        }
        adminOperation.addCourse(params.get("courseName"), Integer.parseInt(params.get("instructorId")), Integer.parseInt(params.get("semester")));
        return "Course "+params.get("courseName")+" Added!";

    }
}