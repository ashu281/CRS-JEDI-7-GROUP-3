package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import javafx.util.Pair;

import java.util.List;

public interface ProfessorDaoInterface {

    public void addGrade(int studentId, int courseId, double grade);


    public List<String> viewEnrolledStudents(int courseId);



    public List<Pair<Integer,String>> getCourses(int profId);

    int getProfId(int userId);
}
