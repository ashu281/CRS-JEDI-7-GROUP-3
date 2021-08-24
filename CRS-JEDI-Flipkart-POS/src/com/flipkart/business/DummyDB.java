package com.flipkart.business;

import com.flipkart.bean.*;

import java.util.HashMap;
import java.util.Map;

public class DummyDB {
    public static Map<String , User>userList;
    public static Map<String, Student>studentList;
    public static Map<String , Professor>professorList;
    public static Map<String , Admin>adminList;
    public static Map<String , Course>courseList;

    public static void createDatabase(){
        userList = new HashMap<String , User>();

        userList.put("U1",new User("A", "Sarthak", "Male", "fakePassword1", "Delhi"));
        userList.put("U2",new User("B", "Rahul", "Male", "fakePassword2", "UP"));
        userList.put("U3",new User("C", "Zain", "Male", "fakePassword3", "UP"));
        userList.put("U4",new User("D", "Riya", "Female", "fakePassword4", "UK"));
        userList.put("U5",new User("E", "Shradha", "Female", "fakePassword5", "Jaipur"));

        studentList = new HashMap<String , Student>();
        studentList.put("S1",new Student("U1", "Sarthak", "Male", "fakePassword1","CSE", "S1", 7, "Delhi"));
        studentList.put("S2",new Student("U2", "Rahul", "Male", "fakePassword2","ECE", "S2", 5, "UP"));
        studentList.get("S1").setApproved(true);

        professorList = new HashMap<String , Professor>();
        professorList.put("P1",new Professor("U3","Zain","Male","fakePassword3","UP","Sample1","CSE","P1"));
        professorList.put("P2",new Professor("U4","Riya","Female","fakePassword4","UK","Sample2","ECE","P2"));

        adminList = new HashMap<String , Admin>();
        adminList.put("A1",new Admin("U5","Shradha","Female","fakePassword5","Jaipur","A1"));

        courseList = new HashMap<String , Course>();

    }

}
