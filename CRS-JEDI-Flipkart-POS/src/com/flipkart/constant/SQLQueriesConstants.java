package com.flipkart.constant;
/**
 *
 * @author JEDI-03
 *
 */

public class SQLQueriesConstants {

    // UserDao Queries
    public static final String VERIFY_CREDENTIALS="select password from user where userId = ?";
    public static final String GET_ROLE="select role from user where userId = ? ";
    public static final String UPDATE_PASSWORD="update user set password=? where userId = ? ";

    //AdminDao Queries
      public static final String DELETE_COURSE = "delete from course where courseId = ?";
      public static final String ADD_COURSE = "insert into course( courseName,profId,semester) values (?, ?, ?)";
      public static final String APPROVE_STUDENT = "update student set isApproved = 1 where studentId = ?";
      public static final String ADD_USER_QUERY = "insert into user(password,role,name,address,gender) values (?, ?, ?, ?,?)";
      public static final String ADD_PROFESSOR = "insert into professor(userId,department, designation) values (?, ?, ?)";

      public static final String ADD_STUDENT="insert into student (branch,semester,userId) values (?,?,?)";



    // Student Queries
      public static final String VIEW_REGISTERED_COURSES=" select * from student_reg_course  inner join course on course.courseId = student_reg_course.courseId where student_reg_course.studentId = ? AND student_reg_course.isApproved = 1";
      public static final String VIEW_AVAILABLE_COURSES=" select * from course where semester = ?";
      public static final String GET_STUDID="select studentId from student where userId = ?";
      public static final String IS_APPROVED="select isApproved from student where studentId = ? ";
      public static final String VIEW_SELECTED_COURSES="select * from student_reg_course  inner join course on course.courseId = student_reg_course.courseId where student_reg_course.studentId = ?";
      public static final String STUDENT_ADD_COURSE="insert into student_reg_course (studentId,courseId,isApproved) values ( ? , ? , true )";
      public static final String STUDENT_DROP_COURSE = "delete from student_reg_course where courseId = ? AND studentId = ?;";
      public static final String VIEW_GRADE = "select * from student_reg_course inner join course on course.courseId = student_reg_course.courseId where studentId = ? AND isApproved = 1 AND semester = ?;";

      // Professor Queries

      public static final String ADD_GRADE="update student_reg_course set grade=? where courseId=? and studentId=?";
      public static final String GET_COURSES="select * from course where profId=?";
      public static final String GET_PROFID="select profId from professor where userId = ?";
      public  static  final  String GET_ENROLLED_STUDENTS = "select student_reg_course.studentId,student.userId,user.name from student_reg_course join student on student.studentId = student_reg_course.studentId join user on user.userId = student.userId where courseId = ?";

}