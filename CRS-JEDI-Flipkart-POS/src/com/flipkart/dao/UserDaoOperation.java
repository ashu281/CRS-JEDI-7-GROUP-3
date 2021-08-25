package com.flipkart.dao;

import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoOperation implements UserDaoInterface {
    Connection connection = DBUtil.getConnection();

    @Override
    public void updatePassword(int userId, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.UPDATE_PASSWORD);
            statement.setString(2, password);
            statement.setInt(1, userId);
            statement.executeUpdate();

        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }



    @Override
    public boolean verifyCredentials(int userId, String password) {
        try
        {
            //open db connection
            PreparedStatement preparedStatement=connection.prepareStatement(SQLQueriesConstants.VERIFY_CREDENTIALS);
            preparedStatement.setInt(1,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                System.out.println("Error fetching details!");
                return false;
            }

            else if(password.equals(resultSet.getString("password")))
            {
                return true;
            }
            else
            {
                return false;
            }

        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());

        }
        finally
        {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public String userType(int userId) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_ROLE);
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();

            if(rs.next())
            {
                return rs.getString("role");
            }

        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
//    Connection c
}
