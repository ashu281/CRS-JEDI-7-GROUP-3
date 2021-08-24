package com.flipkart.business;


import com.flipkart.bean.Student;
import com.flipkart.bean.Professor;
import com.flipkart.business.DummyDB;


import java.util.Map;

/**
 * @author JEDI-07
 * Implementations of Admin Operations
 */


public class AdminOperation implements AdminInterface {

    @Override
    public void addProfessor(String userId, String name, String gender, String password,String address,String designation,String department) {
        int size=DummyDB.professorList.size();
        //Generates unique professorId
        String profId="P"+Integer.toString(size);
        DummyDB.professorList.put(profId,new Professor(userId,name,gender,password,address,designation,department,profId,"P"));
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
    public void addCourse(Course course) {
        DummyDB.courseList.put(course.courseID, course);
    }

    @Override
    public void deleteCourse(String courseID;) {
        DummyDB.courseList.remove(courseID);
    }

    @Override
    public void generateGradeCard() {

    }
}
