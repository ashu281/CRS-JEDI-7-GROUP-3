package com.flipkart.application;

import com.flipkart.business.*;
import com.flipkart.utils.DBUtil;

import java.util.Scanner;

/**
 * @author Abhinav
 */
public class CRSApplicationClient {

    static boolean loggedin = false;
    StudentInterface studentInterface= new StudentOperation();
    UserInterface userInterface = new UserOperation();

    public static void main(String[] args) {

        // initialize database
//        DummyDB.createDatabase();
        DBUtil.getConnection();

        Scanner sc = new Scanner(System.in);
        CRSApplicationClient CRSApplicationClient=new CRSApplicationClient();

        showMainMenu();

        int userInput;
        userInput=sc.nextInt();

        while(userInput!=4)
        {
            switch(userInput)
            {
                case 1:
                    // login
                    CRSApplicationClient.loginUser();
                    break;
                case 2:
                    // student registration
                    CRSApplicationClient.registerStudent();
                    break;
                case 3:
                    // update Password
                    CRSApplicationClient.updatePassword();
                    break;
                default:
                    System.out.println("Invalid input");
            }
            showMainMenu();
            userInput=sc.nextInt();
        }
        sc.close();
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
        String userId,password;

        System.out.println("-----Login-----");
        System.out.println("UserID:");
        userId=sc.next();
        System.out.println("Password:");
        password=sc.next();

        loggedin = userInterface.verifyCredentials(userId, password);

        if(loggedin)
        {
            String userType=userInterface.userType(userId);
            switch(userType) {
                case "A":
                    CRSAdminMenu adminMenu = new CRSAdminMenu();
                    adminMenu.showMenu();
                    break;
                case "P":
                    CRSProfessorMenu professorMenu = new CRSProfessorMenu();
                    professorMenu.showMenu(userId);

                    break;
                case "S":
                    boolean isApproved = studentInterface.isApproved(userId);
                    if (isApproved) {
                        CRSStudentMenu studentMenu = new CRSStudentMenu();
                        studentMenu.showMenu(userId);

                    } else {
                        System.out.println("Administrator approval pending.");
                        loggedin = false;
                    }
                    break;
            }
        }
        else
        {
            System.out.println("Invalid Credentials");
        }
        System.out.println();
    }

    /**
     * Method for Student registration into the system
     */
    public void registerStudent()
    {
        Scanner sc=new Scanner(System.in);

        String userId,name,password,branchName,gender,address;
        int semester;

        System.out.println();
        System.out.println("-----Student Registration-----");
        System.out.println("Name:");
        name=sc.next();
        System.out.println("UserID:");
        userId=sc.next();
        System.out.println("Password:");
        password=sc.next();
        System.out.println("Gender:");
        gender=sc.next();
        System.out.println("Branch:");
        branchName=sc.next();
        System.out.println("Semester:");
        semester=sc.nextInt();
        sc.nextLine();
        System.out.println("Address:");
        address=sc.nextLine();
        System.out.println();

        studentInterface.register(userId, name, password, gender, branchName, semester, address);
    }

    /**
     * Method to Update Password of User
     */
    public void updatePassword()
    {
        Scanner sc=new Scanner(System.in);
        String userId,newPassword;

        System.out.println();
        System.out.println("-----Update Password-----");
        System.out.println("Email");
        userId=sc.next();
        System.out.println("New Password:");
        newPassword=sc.next();
        userInterface.updatePassword(userId, newPassword);
        System.out.println("Password updated successfully.");
        System.out.println();
    }
}
