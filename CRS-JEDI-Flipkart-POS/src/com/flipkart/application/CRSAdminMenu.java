package com.flipkart.application;

import com.flipkart.business.AdminInterface;
import com.flipkart.business.AdminOperation;

import java.util.Scanner;

public class CRSAdminMenu {

    AdminInterface adminOperation = new AdminOperation();
    Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while(CRSApplicationClient.loggedin) {
            System.out.println("-----Admin Choices-----");
            System.out.println("1. Add course in catalog");
            System.out.println("2. Delete Course from catalog");
            System.out.println("3. Approve Student Registration");
            System.out.println("4. Add Professor");
            System.out.println("5. Generate Report Card");
            System.out.println("6. Logout");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addCourse();
                    break;

                case 2:
                    deleteCourse();
                    break;

                case 3:
                    approveStudent();
                    break;

                case 4:
                    addProfessor();
                    break;

                case 5:
                    generateReportCard();
                    break;

                case 6:
                    CRSApplicationClient.loggedin = false;
                    return;

                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private void generateReportCard() {
    }

    private void addProfessor() {
    }

    private void approveStudent() {
    }

    private void deleteCourse() {
    }

    private void addCourse() {
    }
}
