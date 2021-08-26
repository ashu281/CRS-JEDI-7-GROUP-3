package com.flipkart.application;

import com.flipkart.business.AdminInterface;
import com.flipkart.business.AdminOperation;
import com.flipkart.exception.StudentNotFoundForApprovalException;

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
            System.out.println("5. Approve Student Courses");
            System.out.println("6. Generate Report Card");
            System.out.println("7. Logout");
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
                    approveCourse();

                case 6:
                    generateReportCard();
                    break;

                case 7:
                    CRSApplicationClient.loggedin = false;
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    /**
     * Method to approve student's course
     */
    private void approveCourse() {
        int studentId, courseId;
        Scanner sc=new Scanner(System.in);
        System.out.println("-----Course Approval-----");
        System.out.println("StudentID:");
        studentId = sc.nextInt();
        System.out.println("CourseID:");
        courseId = sc.nextInt();
        adminOperation.approveCourse(studentId,courseId);
    }

    /**
     * Method to Add a professor into the system
     */
    private void addProfessor() {
        String name;
        String password;
        String gender;
        String department;
        String designation;
        String address;
        Scanner sc=new Scanner(System.in);

        System.out.println("-----Professor Registration-----");
        System.out.println("Name:");
        name=sc.nextLine();
        System.out.println("Password:");
        password=sc.next();
        System.out.println("Gender:");
        gender=sc.next();
        System.out.println("Department:");
        department=sc.nextLine();
        System.out.println("Designation:");
        designation=sc.nextLine();
        System.out.println("Address:");
        address=sc.nextLine();
        adminOperation.addProfessor(name,gender,password,address,designation,department);
    }

    /**
     * Method to Approve Student Registration
     */
    private void approveStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("StudentID:");
        int studentId = sc.nextInt();
        try{
            adminOperation.approveStudent(studentId);
        }catch (StudentNotFoundForApprovalException ex){
            System.out.println(ex.getMessage());
        }

    }

    /**
     * Method to Delete course from catalogue
     */
    private void deleteCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("CourseID:");
        int courseId = sc.nextInt();
        adminOperation.deleteCourse(courseId);
    }

    /**
     * Method to Add course to catalogue
     */
    private void addCourse() {
        String courseName;
        int instructorId;
        int semester, seatsAvailable=10;
        Scanner sc=new Scanner(System.in);

        System.out.println("-----Add Course-----");
        System.out.println("Course Name:");
        courseName=sc.nextLine();
        System.out.println("ProfessorId:");
        instructorId=sc.nextInt();
        System.out.println("Semester:");
        semester=sc.nextInt();
        adminOperation.addCourse(courseName, instructorId, semester);
    }

    /**
     * Method to Generate Report Card
     */
    private void generateReportCard() {

    }
}
