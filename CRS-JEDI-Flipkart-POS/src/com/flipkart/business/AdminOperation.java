package com.flipkart.business;


import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.Professor;
import com.flipkart.bean.User;
import com.flipkart.business.DummyDB;


import java.util.Map;

/**
 * @author JEDI-07
 * Implementations of Admin Operations
 */


public class AdminOperation implements AdminInterface {

    @Override
    public void addProfessor(String userId, String name, String gender, String password,String address,String designation,String department) {
        int pListSize=DummyDB.professorList.size();
        int uListSize=DummyDB.userList.size();
        //Generates unique professorId
        String profId="P"+Integer.toString(pListSize);
        //Unique key for userList
        String uid="U"+Integer.toString(uListSize);
        DummyDB.professorList.put(profId,new Professor(userId,name,gender,password,address,designation,department,profId,"P"));
        DummyDB.userList.put(uid,new User(userId, name, gender, password, address,"P"));

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
    public void addCourse(String courseID, String courseName, String instructorID, Integer semester, Integer seatsAvailable) {
        Course course = new Course(courseID, courseName, instructorID, semester, seatsAvailable);
        DummyDB.courseList.put(course.getCourseID(), course);
    }
    @Override
    public void deleteCourse(String courseID) {
        DummyDB.courseList.remove(courseID);
    }

    @Override
    public void generateGradeCard() {

    }
}
