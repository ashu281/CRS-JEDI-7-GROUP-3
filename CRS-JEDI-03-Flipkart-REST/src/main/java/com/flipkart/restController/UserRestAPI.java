package com.flipkart.restController;

import com.flipkart.bean.Student;
import com.flipkart.business.*;

import com.flipkart.constant.RoleConstants;
import com.flipkart.dao.ProfessorDaoInterface;
import com.flipkart.dao.ProfessorDaoOperation;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.utils.UserAuth;
import javafx.util.Pair;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * @author Abhinav
 */
@Path("/user")
public class UserRestAPI {

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * Method for Student registration into the system
     */
    public String registerStudent(Map<String,String> m)
    {
        StudentInterface studentInterface = new StudentOperation();
        Pair<Integer,Integer> p = studentInterface.register(m.get("name"), m.get("password"), m.get("gender"), m.get("branch"), Integer.parseInt(m.get("semester")), m.get("address"));
        return "Admin approval pending. UserId: "+p.getValue()+" StudentId: "+p.getKey();
    }
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * Method to verify credentials
     */
    public String verifyCredentials(Map<String,String> map){
        int userId = Integer.parseInt(map.get("userId"));
        String password = map.get("password");
        UserInterface userInterface = new UserOperation();
        Boolean loggedIn = userInterface.verifyCredentials(userId, password);
        if(loggedIn)
        {
            String userType=userInterface.userType(userId);
            switch (userType) {
                case RoleConstants.ADMIN:
                    return UserAuth.loginAdmin(userId);

                case RoleConstants.PROF:

                    ProfessorDaoInterface professorDaoInterface = new ProfessorDaoOperation();
                    int profId = professorDaoInterface.getProfId(userId);
                    return UserAuth.loginProfessor(profId);
                case RoleConstants.STUDENT:
                    StudentInterface studentInterface = new StudentOperation();
                    StudentDaoOperation studentDaoOperation = new StudentDaoOperation();
                    int studentId = studentDaoOperation.getStudentId(userId);
                    boolean isApproved = studentInterface.isApproved(studentId);
                    if (isApproved) {
                        return UserAuth.loginStudent(studentId);
                    } else {
                        return "Approval Pending";
                    }
            }
        }
        else
        {
            return "Invalid Credentials";
        }
        return "PENDING";
    }

    /**
     * Method to Update Password of User
     */

    @POST
    @Path("/updatePassword")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updatePassword(Map<String,String> params,@HeaderParam("authKey") String authKey)
    {
        if(!UserAuth.isUserLogin(authKey)){
            return "Access Denied";
        }
        UserInterface userInterface = new UserOperation();
        userInterface.updatePassword(Integer.parseInt(params.get("userId")), params.get("newPassword"));

        return "Password updated successfully.";

    }
}
