package com.flipkart.application;

import com.flipkart.business.ProfessorInterface;
import com.flipkart.business.ProfessorOperation;

import java.util.Scanner;

public class CRSProfessorMenu {

    ProfessorInterface professorInterface = new ProfessorOperation();
    Scanner sc=new Scanner(System.in);

    public void showMenu(String profId) {
        int input;
        while(CRSApplicationClient.loggedin)
        {
            System.out.println("-----Professor Options-----");
            System.out.println("1. View Courses");
            System.out.println("2. View Enrolled Students");
            System.out.println("3. Add grade");
            System.out.println("4. Logout");

            input=sc.nextInt();
            switch(input)
            {
                case 1:
                    getCourses(profId);
                    break;
                case 2:
                    viewEnrolledStudents(profId);
                    break;

                case 3:
                    addGrade(profId);
                    break;
                case 4:
                    CRSApplicationClient.loggedin=false;
                    return;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private void addGrade(String profId) {

    }

    private void viewEnrolledStudents(String profId) {

    }

    private void getCourses(String profId) {

    }

}
