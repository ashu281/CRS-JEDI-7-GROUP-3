package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Notification;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentDaoOperation implements StudentDaoInterface{

    @Override
    public void register(String name, String password, String gender, String branch, int semester, String address) {
        Connection connection = DBUtil.getConnection();
        try {
            int userId;

            String generatedColumns[] = { "userId" };

            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.ADD_USER_QUERY, generatedColumns);
            statement.setString(1,password);
            statement.setString(2, "S");
            statement.setString(3, name);
            statement.setString(4, address);
            statement.setString(5, gender);
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()){
                userId = rs.getInt(1);

                statement = connection.prepareStatement(SQLQueriesConstants.ADD_STUDENT);
                statement.setString(1, branch);
                statement.setInt(2, semester);
                statement.setInt(3, userId);
                statement.executeUpdate();
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Grade viewGradeCard(int studentId, int semester) {
        Connection connection=DBUtil.getConnection();
        HashMap<String, Double> grades =new HashMap<>();

        try {
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.VIEW_GRADE);

            statement.setInt(1, studentId);
            statement.setInt(2, semester);

            ResultSet results=statement.executeQuery();
            while(results.next())
            {
                grades.put(results.getString("courseName"), results.getDouble("grade"));
            }
            return new Grade(studentId, grades);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean isApproved(int studentId) {
        Connection connection=DBUtil.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.IS_APPROVED);

            statement.setInt(1, studentId);

            ResultSet result = statement.executeQuery();

            if(result.next()){
                return result.getBoolean("isApproved");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Notification makePayment(int studentId, int semester) {
        return new Notification(" ");
    }

    @Override
    public List<Course> getRegisteredCourses(int studentId) {
        Connection connection=DBUtil.getConnection();
        List<Course> registered_courses = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.VIEW_REGISTERED_COURSES);

            statement.setInt(1, studentId);

            ResultSet results=statement.executeQuery();

            while(results.next())
            {
                registered_courses.add(new Course(
                        results.getInt("courseId"),
                        results.getString("courseName"),
                        results.getInt("profId"),
                        results.getInt("semester")
                        ));
            }
            return registered_courses;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Course> getCourses(int semester) {
        Connection connection=DBUtil.getConnection();
        List<Course> registered_courses = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.VIEW_AVAILABLE_COURSES);

            statement.setInt(1, semester);

            ResultSet results=statement.executeQuery();

            while(results.next())
            {
                registered_courses.add(new Course(
                        results.getInt("courseId"),
                        results.getString("courseName"),
                        results.getInt("profId"),
                        results.getInt("semester")
                ));
            }
            return registered_courses;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addCourse(int studentId, int courseId) {
        Connection connection = DBUtil.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.STUDENT_ADD_COURSE);

            statement.setInt(1, studentId);
            statement.setInt(2, courseId);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropCourse(int studentId, int courseId) {
        Connection connection=DBUtil.getConnection();

        try{
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.STUDENT_DROP_COURSE);

            statement.setInt(1, studentId);
            statement.setInt(2, courseId);

            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
