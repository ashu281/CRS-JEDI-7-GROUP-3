package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.business.StudentInterface;
import com.flipkart.business.StudentOperation;

import java.util.List;
import java.util.Scanner;

/**
 * @author Abhinav
 */
public class CRSStudentMenu {

    StudentInterface studentInterface = new StudentOperation();
    Scanner sc = new Scanner(System.in);

    /**
     * Method to Show the student menu
     * @param studentId
     */
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
            System.out.println("Enter choice:-");

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
                    System.out.println("Invalid choice");
            }
        }
    }

    /**
     * Method to Make payment for the semester
     * @param studentId
     */
    private void makePayment(String studentId) {
        System.out.println("-----Make Payment-----");
        System.out.println("Semester:");
        int semester=sc.nextInt();
        studentInterface.makePayment(studentId,semester);
    }

    /**
     * Method to View Grade card for the semester
     * @param studentId
     */
    private void viewGradeCard(String studentId) {
        System.out.println("-----View Grade Card-----");
        System.out.println("Semester:");
        int semester=sc.nextInt();
        studentInterface.viewGradeCard(studentId,semester); // Currently, function is void
    }

    /**
     * Method to View enrolled courses
     * @param studentId
     */
    private void viewRegisteredCourse(String studentId) {
        List<Course> courseList = studentInterface.getRegisteredCourses(studentId);
        for(Course course: courseList) {
            System.out.println(course.getCourseID() + "\t" + course.getCourseName());
        }
    }

    /**
     * Method to View available courses
     * @param studentId
     */
    private void viewCourse(String studentId) {
        List<Course> courseList = studentInterface.getCourses(studentId);
        for(Course course: courseList) {
            System.out.println(course.getCourseID() + "\t" + course.getCourseName());
        }
    }

    /**
     * Method to Add a course
     * @param studentId
     */
    private void addCourse(String studentId) {
        String courseId;
        System.out.println("-----Enrolled Students-----");
        System.out.println("Course Code:");
        courseId=sc.next();
        studentInterface.addCourse(courseId);
    }

    /**
     * Method to Drop a course
     * @param studentId
     */
    private void dropCourse(String studentId) {
        String courseId;
        System.out.println("-----Enrolled Students-----");
        System.out.println("Course Code:");
        courseId=sc.next();
        studentInterface.dropCourse(courseId);
    }

    /**
     * Method to Register for selected courses
     * @param studentId
     */
    private void registerCourses(String studentId) {
        studentInterface.registerForCourses(studentId);
    }
}
