package com.flipkart.application;

import com.flipkart.business.StudentInterface;
import com.flipkart.business.StudentOperation;

import java.util.Scanner;

public class CRSStudentMenu {

    StudentInterface studentInterface = new StudentOperation();
    Scanner sc = new Scanner(System.in);

    public void showMenu(String studentId) {
        while (CRSApplicationClient.loggedin)
        {
            System.out.println("-----Student Choices-----");
            System.out.println("1. Course Registration");
            System.out.println("2. Add Course");
            System.out.println("3. Drop Course");
            System.out.println("4. View Course");
            System.out.println("5. View Registered Courses");
            System.out.println("6. View Grade Card");
            System.out.println("7. Make Payment");
            System.out.println("8. Logout");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    registerCourses(studentId);
                    break;

                case 2:
                    addCourse(studentId);
                    break;

                case 3:

                    dropCourse(studentId);
                    break;

                case 4:
                    viewCourse(studentId);
                    break;

                case 5:
                    viewRegisteredCourse(studentId);
                    break;

                case 6:
                    viewGradeCard(studentId);
                    break;

                case 7:
                    makePayment(studentId);
                    break;

                case 8:
                    CRSApplicationClient.loggedin = false;
                    return;

                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private void makePayment(String studentId) {
    }

    private void viewGradeCard(String studentId) {
    }

    private void viewRegisteredCourse(String studentId) {
    }

    private void viewCourse(String studentId) {
    }

    private void dropCourse(String studentId) {
    }

    private void addCourse(String studentId) {
    }

    private void registerCourses(String studentId) {
    }
}
