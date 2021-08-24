package com.flipkart.business;


import com.flipkart.bean.Student;
import com.flipkart.bean.Professor;

import java.util.Map;

/**
 *
 * @author JEDI-07
 * Implementations of Admin Operations
 *
 */


public class AdminOperation implements AdminInterface{
    @Override
    public void addProfessor() {

    }

    @Override
    public void approveStudent(String studentId) {
        Map<String, Student> studentList = DummyDB.studentList;
        if(studentList.containsKey(studentId)){
            Student student = studentList.get(studentId);
            if(student.isApproved()){
                System.out.println("Student already approved");
            }else{
                student.setApproved(true);
                System.out.println("Successfully Approved " + student.getName());
            }
        }else{
            System.out.println("Student " + studentId + " doesn't exists");
        }
    }

    @Override
    public void addCourse() {

    }

    @Override
    public void deleteCourse() {

    }

    @Override
    public void generateGradeCard() {

    }
}
