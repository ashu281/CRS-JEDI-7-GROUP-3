package com.flipkart.business;


import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.Professor;
import com.flipkart.bean.User;


import java.util.Map;

/**
 * @author JEDI-07
 * Implementations of Admin Operations
 */


public class AdminOperation implements AdminInterface {


    /**
     *
     * Method to add a new professor
     * @param userId
     * @param name
     * @param gender
     * @param password
     * @param address
     * @param designation
     * @param department
     */
    @Override
    public void addProfessor(int userId, String name, String gender, String password, String address, String designation, String department) {
        int pListSize=DummyDB.professorList.size();
        int uListSize=DummyDB.userList.size();
        //Generates unique professorId
        int profId=pListSize+1;
        //Unique key for userList
        int uid=uListSize+1;
        DummyDB.professorList.put(profId,new Professor(userId,name,gender,password,address,designation,department,profId,"P"));
        DummyDB.userList.put(uid,new User(userId, name, gender, password, address,"P"));

    }

    /**+
     * Method to approve registration of a Student
     * @param studentId
     */
    @Override
    public void approveStudent(String studentId) {
        Map<Integer, Student> studentList = DummyDB.studentList;
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
    
    /**
     * Method to add courses in the catalog
     *
     * @param courseID
     * @param courseName
     * @param instructorID
     * @param semester
     * @param seatsAvailable
     */
    @Override
    public void addCourse(int courseID, String courseName, int instructorID, Integer semester, Integer seatsAvailable) {
        Course course = new Course(courseID, courseName, instructorID, semester, seatsAvailable);
        DummyDB.courseList.put(course.getCourseID(), course);
    }
    
    /**
     * Method to delete courses in the catalog
     *
     * @param courseID
     */
    @Override
    public void deleteCourse(String courseID) {
        DummyDB.courseList.remove(courseID);
    }

    @Override
    public void generateGradeCard() {

    }
}
