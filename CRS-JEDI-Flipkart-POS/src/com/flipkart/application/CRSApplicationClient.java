package com.flipkart.application;

import com.flipkart.business.*;
import com.flipkart.dao.*;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.DBUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Abhinav
 */
public class CRSApplicationClient {

    static boolean loggedIn = false;
    StudentInterface studentInterface= new StudentOperation();
    UserInterface userInterface = new UserOperation();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CRSApplicationClient CRSApplicationClient=new CRSApplicationClient();

        showMainMenu();

        int userInput=0;
        try {
            userInput = sc.nextInt();
        }
        catch (InputMismatchException ex) {
            System.out.println(ex.getMessage());
        }

        while(userInput!=4)
        {
            switch (userInput) {
                // login
                case 1:
                    CRSApplicationClient.loginUser();
                    break;
                // student registration
                case 2:
                    CRSApplicationClient.registerStudent();
                    break;
                // update Password
                case 3:
                    CRSApplicationClient.updatePassword();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            showMainMenu();
            userInput=sc.nextInt();
        }
        sc.close();
        DBUtil.closeConnection();
    }

    /**
     * Method to Show the main CRS Menu
     */
    public static void showMainMenu()
    {
        System.out.println("--------------WELCOME-------------");
        System.out.println("-----Course Management System-----");
        System.out.println("1. Login");
        System.out.println("2. Student Registration");
        System.out.println("3. Update password");
        System.out.println("4. Exit");
        System.out.println("Enter choice:-");
    }


    /**
     * Method to Log-in to the CRS
     */
    public void loginUser()
    {
        Scanner sc=new Scanner(System.in);
        String password;
        int userId;

        try {
            System.out.println("-----Login-----");
            System.out.println("UserID:");
            userId = sc.nextInt();
            System.out.println("Password:");
            password = sc.next();
        }
        catch(InputMismatchException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        try{
            loggedIn = userInterface.verifyCredentials(userId, password);
            if(loggedIn)
            {

                String userType=userInterface.userType(userId);
                switch (userType) {
                    case "A":
                        CRSAdminMenu adminMenu = new CRSAdminMenu();
                        adminMenu.showMenu();
                        break;
                    case "P":
                        CRSProfessorMenu professorMenu = new CRSProfessorMenu();
                        ProfessorDaoInterface professorDaoInterface = new ProfessorDaoOperation();
                        int profId = professorDaoInterface.getProfId(userId);
                        professorMenu.showMenu(profId);
                        break;
                    case "S":
                        StudentDaoOperation studentDaoOperation = new StudentDaoOperation();
                        int studentId = studentDaoOperation.getStudentId(userId);
                        boolean isApproved = studentInterface.isApproved(studentId);
                        if (isApproved) {
                            CRSStudentMenu studentMenu = new CRSStudentMenu();
                            studentMenu.showMenu(studentId);

                        } else {
                            System.out.println("Administrator approval pending.");
                            loggedIn = false;
                        }
                        break;
                }
            }
            else
            {
                System.out.println("Invalid Credentials");
            }
        }catch (UserNotFoundException ex){
            System.out.println(ex.getMessage());
        }

    }

    /**
     * Method for Student registration into the system
     */
    public void registerStudent()
    {
        Scanner sc=new Scanner(System.in);

        String name,password,branchName,gender,address;
        int semester;

        try {
            System.out.println();
            System.out.println("-----Student Registration-----");
            System.out.println("Name:");
            name = sc.next();
            System.out.println("Password:");
            password = sc.next();
            System.out.println("Gender:");
            gender = sc.next();
            System.out.println("Branch:");
            branchName = sc.next();
            System.out.println("Semester:");
            semester = sc.nextInt();
            sc.nextLine();
            System.out.println("Address:");
            address = sc.nextLine();
            System.out.println();
        }
        catch(InputMismatchException ex) {
            System.out.println(ex.getMessage());
            return;
        }
        studentInterface.register(name, password, gender, branchName, semester, address);
    }

    /**
     * Method to Update Password of User
     */
    public void updatePassword()
    {
        Scanner sc=new Scanner(System.in);
        String password;
        int userId;

        try {
            System.out.println("-----Login-----");
            System.out.println("UserID:");
            userId = sc.nextInt();
            System.out.println("Password:");
            password = sc.nextLine();
        }
        catch(InputMismatchException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        try{
            loggedIn = userInterface.verifyCredentials(userId, password);

            if(loggedIn) {
                String newPassword;

                System.out.println();
                System.out.println("-----Update Password-----");
                System.out.println("New Password:");
                newPassword = sc.next();
                userInterface.updatePassword(userId, newPassword);
                System.out.println("Password updated successfully.");
                System.out.println();
            }
            else {
                System.out.println("Invalid Credentials");
            }
        }catch (UserNotFoundException ex){
            System.out.println(ex.getMessage());
        }

    }
}
