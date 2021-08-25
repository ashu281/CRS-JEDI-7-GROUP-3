package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.business.ProfessorInterface;
import com.flipkart.business.ProfessorOperation;
import javafx.util.Pair;

import java.util.List;
import java.util.Scanner;

/**
 * @author Abhinav
 */
public class CRSProfessorMenu {

    ProfessorInterface professorInterface = new ProfessorOperation();
    Scanner sc = new Scanner(System.in);

    /**
     * Method to Show the professor Menu
     * @param profId
     */
    public void showMenu(int profId) {
        int input;
        while(CRSApplicationClient.loggedin)
        {
            System.out.println("-----Professor Options-----");
            System.out.println("1. View Courses");
            System.out.println("2. View Enrolled Students");
            System.out.println("3. Add grade");
            System.out.println("4. Logout");
            System.out.println("Enter choice:-");

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
                    System.out.println("Invalid choice");
            }
        }
    }

    /**
     * Method to Add grade for a given student and course
     * @param profId
     */
    private void addGrade(int profId) {
        double grade;
        int studentId, courseId;
        System.out.println("-----Add Grade-----");
        System.out.println("StudentID:");
        studentId=sc.nextInt();
        System.out.println("Course Code:");
        courseId=sc.nextInt();
        System.out.println("Grade:");
        grade=sc.nextDouble();
        professorInterface.addGrade(studentId,courseId,grade);
    }

    /**
     * Method to View enrolled students for a specific course
     * @param profId
     */
    private void viewEnrolledStudents(int profId) {
        System.out.println("-----Enrolled Students-----");
        System.out.println("Course Code:");
        int courseId=sc.nextInt();
        List<String> studentList =  professorInterface.viewEnrolledStudents(courseId);
        for(String student: studentList) {
            System.out.println(student);
        }
    }

    /**
     * Method to Get course list that professor teaches
     * @param profId
     */
    private void getCourses(int profId) {
        List<Pair<Integer,String>> courseList = professorInterface.getCourses(profId);
        for(Pair<Integer,String>course: courseList) {
            System.out.println(course);
        }
    }

}
