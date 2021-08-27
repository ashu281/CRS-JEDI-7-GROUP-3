package com.flipkart.restController;

import com.flipkart.bean.Student;
import com.flipkart.business.*;

import com.flipkart.constant.ConsoleColors;
import com.flipkart.constant.RoleConstants;
import com.flipkart.dao.ProfessorDaoInterface;
import com.flipkart.dao.ProfessorDaoOperation;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.exception.UserNotFoundException;
import org.apache.log4j.Logger;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

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
    public String registerStudent(Student student)
    {
        StudentInterface studentInterface = new StudentOperation();
        studentInterface.register(student.getName(), student.getPassword(), student.getGender(), student.getBranch(), student.getSemester(), student.getAddress());
        return "Admin approval pending";
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

                    break;
                case RoleConstants.PROF:

                    ProfessorDaoInterface professorDaoInterface = new ProfessorDaoOperation();
                    int profId = professorDaoInterface.getProfId(userId);
//                    UserAuth
                    break;
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
//    /**
//     * Method to Update Password of User
//     */
//    public void updatePassword()
//    {
//        Scanner sc=new Scanner(System.in);
//        String password;
//        int userId;
//
//        try {
//            System.out.println("-----Login-----");
//            System.out.println("UserID:");
//            userId = sc.nextInt();
//            sc.nextLine();
//            System.out.println("Password:");
//            password = sc.nextLine();
//        }
//        catch(InputMismatchException ex) {
//            System.out.println("UserID must contain only digits");
//            System.out.println();
//            return;
//        }
//            loggedIn = userInterface.verifyCredentials(userId, password);
//
//            if(loggedIn) {
//                String newPassword;
//
//                System.out.println();
//                System.out.println("-----Update Password-----");
//                System.out.println("New Password:");
//                newPassword = sc.nextLine();
//                userInterface.updatePassword(userId, newPassword);
//                System.out.println("Password updated successfully.");
//                System.out.println();
//            }
//            else {
//                System.out.println("Invalid Credentials");
//            }
//
//
//    }
}
