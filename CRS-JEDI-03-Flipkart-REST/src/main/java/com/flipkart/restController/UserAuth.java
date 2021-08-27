package com.flipkart.restController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UserAuth {
    public static Map<String,Integer> loggedInStudents = new HashMap<>();
    public static Map<String,Integer> loggedInProfessor = new HashMap<>();
    public static Map<String,Integer> loggedInAdmin = new HashMap<>();

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

    public static String loginStudent(int studentId){
        String key = generateRandomString();
        loggedInStudents.put(key,studentId);
        return key;
    }
    public static void logoutStudent(String key){
        loggedInStudents.remove(key);
    }

    public static int isStudentLogin(String key){
        if(loggedInStudents.containsKey(key))
            return loggedInStudents.get(key);
        else return -1;
    }





//    public static void loginAdmin(int adminId){
//        loggedInAdmin.put(adminId,generateRandomString());
//    }
//    public static void logoutAdmin(int adminId){
//        loggedInAdmin.remove(adminId);
//    }
//    public static boolean  isAdminLogin(int adminId){
//        return loggedInAdmin.containsKey(adminId);
//    }
//
//
//
//
//    public static void loginProfessor(int profId){
//        loggedInProfessor.put(profId,generateRandomString());
//    }
//    public static void logoutProfessor(int profId){
//        loggedInProfessor.remove(profId);
//    }
//    public static boolean  isProfessorLogin(int profId){
//        return loggedInProfessor.containsKey(profId);
//    }
}
