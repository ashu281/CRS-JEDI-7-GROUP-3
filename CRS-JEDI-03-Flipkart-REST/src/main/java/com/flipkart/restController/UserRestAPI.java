package com.flipkart.restController;

import com.flipkart.bean.Student;
import com.flipkart.business.*;

import org.apache.log4j.Logger;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.InputMismatchException;
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
