package com.flipkart.dao;

import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.utils.DBUtil;
import javafx.util.Pair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDaoOperation implements ProfessorDaoInterface{
    Connection connection = DBUtil.getConnection();
    @Override
    public void addGrade(int studentId, int courseId, double grade) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.ADD_GRADE);
            statement.setDouble(1, grade);
            statement.setInt(2,courseId);
            statement.setInt(3,studentId);
            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<String> viewEnrolledStudents(int courseId) {
        List<String> students = new ArrayList<String>();
        try {
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_ENROLLED_STUDENTS);
            statement.setInt(1,courseId);
            ResultSet results=statement.executeQuery();

            while(results.next())
            {
                students.add(results.getString("name"));

            }
            return students;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return students;
    }

    @Override
    public List<Pair<Integer, String>> getCourses(int profId) {
        List<Pair<Integer, String>> courses = new ArrayList<Pair<Integer, String>>();
        try {
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_COURSES);
            statement.setInt(1,profId);
            ResultSet results=statement.executeQuery();

            while(results.next())
            {
                courses.add(new Pair<Integer,String>(results.getInt("courseId"),results.getString("name")));


            }
            return courses;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }


}
