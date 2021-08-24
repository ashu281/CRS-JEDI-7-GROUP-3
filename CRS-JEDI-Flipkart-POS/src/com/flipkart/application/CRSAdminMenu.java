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

    private void addProfessor() {
        String userId,name,password,gender,department,designation,address;
        Scanner sc=new Scanner(System.in);

        System.out.println("-----Professor Registration-----");
        System.out.println("Name:");
        name=sc.nextLine();
        System.out.println("UserID:");
        userId=sc.next();
        System.out.println("Password:");
        password=sc.next();
        System.out.println("Gender: ('Male', 'Female', 'Other')");
        gender=sc.nextLine();
        System.out.println("Department:");
        department=sc.nextLine();
        System.out.println("Designation:");
        designation=sc.nextLine();
        System.out.println("Address:");
        address=sc.nextLine();
        adminOperation.addProfessor(userId,name,gender,password,address,designation,department);
    }

    private void approveStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("StudentID:");
        String studentId = sc.next();
        adminOperation.approveStudent(studentId);
    }

    private void deleteCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("CourseID:");
        String courseId = sc.next();
        adminOperation.deleteCourse(courseId);
    }

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
    private void generateReportCard() {

    }
}
