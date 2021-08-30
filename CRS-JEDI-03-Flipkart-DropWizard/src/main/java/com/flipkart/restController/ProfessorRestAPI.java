package com.flipkart.restController;

import com.flipkart.business.ProfessorInterface;
import com.flipkart.business.ProfessorOperation;
import com.flipkart.utils.UserAuth;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

/**
 * @author Sarthak
 */
@Path("/professor")
public class ProfessorRestAPI {

    ProfessorInterface professorInterface = new ProfessorOperation();

    /**
     * Method to Add grade for a given student and course
     * @param
     */

    @POST
    @Path("/addGrade")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addGrade(Map<String,String> params, @HeaderParam("authKey") String authKey) {
        if(UserAuth.isProfessorLogin(authKey) ==null){
            return "Access Denied!";
        }
        professorInterface.addGrade(Integer.parseInt(params.get("studentId")),Integer.parseInt(params.get("courseId")),Double.parseDouble(params.get("grade")));
        return "Grade added successfully!";
    }

    /**
     * Method to View enrolled students for a specific course
     * @param
     */

    @POST
    @Path("/viewEnrolledStudents")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object viewEnrolledStudents(Map<String,String> params, @HeaderParam("authKey") String authKey) {
        if(UserAuth.isProfessorLogin(authKey) ==null){
            //TODO CHECK IF IT WORKS!
            return "Access Denied!";
        }
        return professorInterface.viewEnrolledStudents(Integer.parseInt(params.get("courseId")));
    }

    /**
     * Method to Get course list that professor teaches
     * @param
     */
    @GET
    @Path("/getCourses")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object getCourses(@HeaderParam("authKey") String authKey) {
        if(UserAuth.isProfessorLogin(authKey) ==null){
            //TODO CHECK IF IT WORKS!
            return "Access Denied!";
        }
        return professorInterface.getCourses(UserAuth.isProfessorLogin(authKey));
    }

}
