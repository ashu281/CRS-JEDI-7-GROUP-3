package com.flipkart.restController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UserAuth {
    public static Map<Integer,String> loggedInStudents = new HashMap<Integer,String>();
    public static Map<Integer,String> loggedInProfessor = new HashMap<Integer,String>();
    public static Map<Integer,String> loggedInAdmin = new HashMap<Integer,String>();

    public static String generateRandomString(){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public static void loginStudent(int studentId){
        loggedInStudents.put(studentId,generateRandomString());
    }
    public static void logoutStudent(int studentId){
        loggedInStudents.remove(studentId);
    }

    public static boolean  isStudentLogin(int studentId){
        return loggedInStudents.containsKey(studentId);
    }





    public static void loginAdmin(int adminId){
        loggedInAdmin.put(adminId,generateRandomString());
    }
    public static void logoutAdmin(int adminId){
        loggedInAdmin.remove(adminId);
    }
    public static boolean  isAdminLogin(int adminId){
        return loggedInAdmin.containsKey(adminId);
    }




    public static void loginProfessor(int profId){
        loggedInProfessor.put(profId,generateRandomString());
    }
    public static void logoutProfessor(int profId){
        loggedInProfessor.remove(profId);
    }
    public static boolean  isProfessorLogin(int profId){
        return loggedInProfessor.containsKey(profId);
    }
}
