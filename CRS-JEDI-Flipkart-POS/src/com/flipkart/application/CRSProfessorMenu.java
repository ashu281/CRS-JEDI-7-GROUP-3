package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.business.ProfessorInterface;
import com.flipkart.business.ProfessorOperation;

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
    public void showMenu(String profId) {
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
    private void addGrade(String profId) {
        String studentId, courseId, grade;
        System.out.println("-----Add Grade-----");
        System.out.println("StudentID:");
        studentId=sc.next();
        System.out.println("Course Code:");
        courseId=sc.next();
        System.out.println("Grade:");
        grade=sc.next();
        professorInterface.addGrade(studentId,courseId,grade);
    }

    /**
     * Method to View enrolled students for a specific course
     * @param profId
     */
    private void viewEnrolledStudents(String profId) {
        String courseId;
        System.out.println("-----Enrolled Students-----");
        System.out.println("Course Code:");
        courseId=sc.next();
        List<Student> studentList =  professorInterface.viewEnrolledStudents(profId,courseId);
        for(Student student: studentList) {
            System.out.println(student.getStudentId() + "\t" + student.getName());
        }
    }

    /**
     * Method to Get course list that professor teaches
     * @param profId
     */
    private void getCourses(String profId) {
        List<Course> courseList = professorInterface.getCourses(profId);
        for(Course course: courseList) {
            System.out.println(course.getCourseID() + "\t" + course.getCourseName());
        }
    }

}
