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
      public static final String ADD_COURSE = "insert into course( name,profId,semester) values (?, ?, ?)";
//    public static final String VIEW_PENDING_ADMISSION_QUERY = "select userId, name, password, role, gender, address, country, studentId from student natural join user where isApproved = 0";
      public static final String APPROVE_STUDENT = "update student set isApproved = 1 where studentId = ?";
      public static final String ADD_USER_QUERY = "insert into user(password,role,name,address,gender) values (?, ?, ?, ?,?)";
      public static final String ADD_PROFESSOR = "insert into professor(userId,department, designation) values (?, ?, ?)";
//    public static final String ASSIGN_COURSE_QUERY = "update Course set professorId = ? where courseCode = ?";
//    public static final String VIEW_COURSE_QUERY = "select courseCode, courseName, professorId from Course where catalogId = ?";
//    public static final String VIEW_PROFESSOR_QUERY = "select userId, name, gender, department, designation, address, country from Professor natural join User";
//
      public static final String ADD_STUDENT="insert into student (studentId,branch,semester,userId) values (?,?,?,?)";
//    public static final String VERIFY_CREDENTIALS="select password from user where userId = ?";
//    public static final String GET_ROLE="select role from user where userId = ? ";
      public static final String IS_APPROVED="select isApproved from student where studentId = ? ";
//    public static final String GET_STUDENT_ID="select studentId from student where userId = ? ";
//    public static final String UPDATE_PASSWORD="update user set password=? where userId = ? ";
//    public static final String GET_PROF_NAME = "select name from user where userId = ?";
//
//    // Student Queries
      public static final String VIEW_REGISTERED_COURSES=" select * from student_reg_course  inner join course on course.courseId = student_reg_course.courseId where student_reg_course.studentId = ? AND student_reg_course.isApproved = 1";
      public static final String VIEW_AVAILABLE_COURSES=" select * from course where semester = ?";

//    public static final String CHECK_COURSE_AVAILABILITY=" select courseCode from registeredcourse where studentId = ? ";
//    public static final String DECREMENT_COURSE_SEATS="update course set seats = seats-1 where courseCode = ? ";
//      public static final String ADD_COURSE="insert into student_reg_course (studentId,courseId) values ( ? , ? )";
      public static final String DROP_COURSE = "delete from student_reg_course where courseId = ? AND studentId = ?;";
//    public static final String INCREMENT_SEAT_QUERY  = "update course set seats = seats + 1 where  courseCode = ?;";
//    public static final String CALCULATE_FEES  = "select sum(courseFee) from course where courseCode in (select courseCode from registeredcourse where studentId = ?);";
      public static final String VIEW_GRADE = "select * from student_reg_course inner join course on course.courseId = student_reg_course.courseId where courseId = ? AND studentId = ? AND isApproved = 1;";
  //    public static final String GET_SEATS = "select seats from course where courseCode = ?;";
//    public static final String INSERT_PAYMENT = "insert into payment(studentId,modeofPayment,referenceId,amount) values(?,?,?,?);";
//    public static final String INSERT_NOTIFICATION = "insert into notification(studentId,type,referenceId) values(?,?,?);";
//    public static final String GET_NOTIFICATION = "select * from notification where referenceId = ?;";
      public static final String ADD_GRADE="update student_reg_course set grade=? where courseId=? and studentId=?";
      public static final String GET_COURSES="select * from course where profId=?";
//    public static final String GET_REGISTRATION_STATUS=" select isRegistered from student where studentId = ? ";
//    public static final String SET_REGISTRATION_STATUS="update student set isRegistered = true  where studentId=?";
      public  static  final  String GET_ENROLLED_STUDENTS = "select studentId from student_reg_course where courseId = ?";
//      public static final String GET_ENROLLED_STUDENTS="select course.courseId,course.name,student_reg_course.studentId from course inner join student_reg_course on course.courseId = student_reg_course.courseId where course.profId = ? order by course.courseId";
//    public static final String NUMBER_OF_REGISTERED_COURSES=" select studentId from registeredcourse where studentId = ? ";
//    public static final String IS_REGISTERED=" select courseCode from registeredcourse where courseCode=? and studentId=? ";
}
