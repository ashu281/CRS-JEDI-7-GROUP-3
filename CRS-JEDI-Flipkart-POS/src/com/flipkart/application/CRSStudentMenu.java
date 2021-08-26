package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.business.StudentInterface;
import com.flipkart.business.StudentOperation;
import com.flipkart.exception.CourseLimitExceedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.GradeNotAddedException;

import java.util.*;

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
    public void showMenu(int studentId) {
        System.out.println("--------Welcome Student--------");
        while (CRSApplicationClient.loggedIn)
        {
            System.out.println("--------Student Choices--------");
            System.out.println("1. Course Registration");
            System.out.println("2. Add Course");
            System.out.println("3. Drop Course");
            System.out.println("4. View Available Courses");
            System.out.println("5. View Registered Courses");
            System.out.println("6. View Grade Card");
            System.out.println("7. Make Payment");
            System.out.println("8. Logout");
            System.out.println("Enter choice:-");

            String choice="0";
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    registerCourses(studentId);
                    break;
                case "2":
                    addCourse(studentId);
                    break;
                case "3":
                    dropCourse(studentId);
                    break;
                case "4":
                    viewCourse(studentId);
                    break;
                case "5":
                    viewRegisteredCourse(studentId);
                    break;
                case "6":
                    viewGradeCard(studentId);
                    break;
                case "7":
                    makePayment(studentId);
                    break;
                case "8":
                    CRSApplicationClient.loggedIn = false;
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    /**
     * Method to Make payment for the semester
     * @param studentId
     */
    private void makePayment(int studentId) {
        System.out.println("-----Make Payment-----");
        System.out.println("Semester:");
        int semester;
        try {
            semester = sc.nextInt();
            sc.nextLine();
        } catch(InputMismatchException ex) {
            System.out.println("Semester must be a digit");
            System.out.println();
            return;
        }
        studentInterface.makePayment(studentId,semester);
    }

    /**
     * Method to View Grade card for the semester
     * @param studentId
     */
    private void viewGradeCard(int studentId) {
        System.out.println("-----View Grade Card-----");
        System.out.println("Semester:");
        int semester;
        try {
            semester = sc.nextInt();
            sc.nextLine();
        } catch(InputMismatchException ex) {
            System.out.println("Semester must be a digit");
            System.out.println();
            return;
        }
        try{
            Grade gradeCard = studentInterface.viewGradeCard(studentId,semester);
            HashMap <String, Double> grades = gradeCard.getGrades();

            for (Map.Entry mapElement : grades.entrySet()) {
                String courseName = (String) mapElement.getKey();
                Double grade = (Double) mapElement.getValue();

                System.out.println(courseName + " : " + grade);
            }
        }catch (GradeNotAddedException ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Method to View enrolled courses
     * @param studentId
     */
    private void viewRegisteredCourse(int studentId) {
        List<Course> courseList = studentInterface.getRegisteredCourses(studentId);
        for(Course course: courseList) {
            System.out.println(course.getCourseID() + "\t" + course.getCourseName());
        }
    }

    /**
     * Method to View available courses
     * @param studentId
     */
    private void viewCourse(int studentId) {
        List<Course> courseList = studentInterface.getCourses(studentId);
        for(Course course: courseList) {
            System.out.println(course.getCourseID() + "\t" + course.getCourseName());
        }
    }

    /**
     * Method to Add a course
     * @param studentId
     */
    private void addCourse(int studentId) {
        int courseId;
        System.out.println("-----Enrolled Students-----");
        System.out.println("Course Code:");
        try {
            courseId = sc.nextInt();
            sc.nextLine();
        } catch(InputMismatchException ex) {
            System.out.println("Course Code must be a digit");
            System.out.println();
            return;
        }
        try{
            studentInterface.addCourse(courseId, studentId);
        }catch (CourseNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch (CourseLimitExceedException ex){
            System.out.println(ex.getMessage());
        }

    }

    /**
     * Method to Drop a course
     * @param studentId
     */
    private void dropCourse(int studentId) {
        int courseId;
        System.out.println("-----Enrolled Students-----");
        System.out.println("Course Code:");
        try {
            courseId = sc.nextInt();
            sc.nextLine();
        } catch(InputMismatchException ex) {
            System.out.println("Course Code must be a digit");
            System.out.println();
            return;
        }

        try {
            studentInterface.dropCourse(courseId, studentId);
        }catch (CourseNotFoundException ex){
            System.out.println(ex.getMessage());
        }

    }

    /**
     * Method to Register for selected courses
     * @param studentId
     */
    private void registerCourses(int studentId) {
        studentInterface.registerForCourses(studentId);
    }
}
