package com.flipkart.application;

import com.flipkart.business.AdminInterface;
import com.flipkart.business.AdminOperation;

import java.util.Scanner;

/**
 * @author Abhinav
 */
public class CRSAdminMenu {

    AdminInterface adminOperation = new AdminOperation();
    Scanner scanner = new Scanner(System.in);

    /**
     * Method to Show the Admin Menu
     */
    public void showMenu() {
        while(CRSApplicationClient.loggedin) {
            System.out.println("----------Welcome Admin----------");
            System.out.println("----------Admin Choices----------");
            System.out.println("1. Add course in catalog");
            System.out.println("2. Delete Course from catalog");
            System.out.println("3. Approve Student Registration");
            System.out.println("4. Add Professor");
            System.out.println("5. Generate Report Card");
            System.out.println("6. Logout");
            System.out.println("Enter choice:-");

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
                    System.out.println("Invalid choice");
            }
        }
    }

    /**
     * Method to Add a professor into the system
     */
    private void addProfessor() {
        String userId,name,password,gender,department,designation,address;
        Scanner sc=new Scanner(System.in);

        System.out.println("-----Professor Registration-----");
        System.out.println("Name:");
        name=sc.next();
        System.out.println("UserID:");
        userId=sc.next();
        System.out.println("Password:");
        password=sc.next();
        System.out.println("Gender:");
        gender=sc.next();
        System.out.println("Department:");
        department=sc.next();
        System.out.println("Designation:");
        designation=sc.next();
        System.out.println("Address:");
        address=sc.next();
        adminOperation.addProfessor(userId,name,gender,password,address,designation,department);
    }

    /**
     * Method to Approve Student Registration
     */
    private void approveStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("StudentID:");
        String studentId = sc.next();
        adminOperation.approveStudent(studentId);
    }

    /**
     * Method to Delete course from catalogue
     */
    private void deleteCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("CourseID:");
        String courseId = sc.next();
        adminOperation.deleteCourse(courseId);
    }

    /**
     * Method to Add course to catalogue
     */
    private void addCourse() {
        String courseId,courseName,instructorId;
        int semester, seatsAvailable=10;
        Scanner sc=new Scanner(System.in);

        System.out.println("-----Add Course-----");
        System.out.println("Course Name:");
        courseName=sc.nextLine();
        System.out.println("CourseID:");
        courseId=sc.next();
        System.out.println("InstructorId:");
        instructorId=sc.next();
        System.out.println("Semester:");
        semester=sc.nextInt();
        adminOperation.addCourse(courseId, courseName, instructorId, semester, seatsAvailable);
    }

    /**
     * Method to Generate Report Card
     */
    private void generateReportCard() {

    }
}
