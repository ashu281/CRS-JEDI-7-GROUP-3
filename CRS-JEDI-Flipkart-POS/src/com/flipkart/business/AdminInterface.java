package com.flipkart.business;

/**
 *
 * @author JEDI-07
 * Interface for Admin Operations
 *
 */

public interface AdminInterface {

	/**
	 * Method to add a new professor
	 *
	 */
	public void addProfessor(int userId, String name, String gender, String password, String address, String designation, String department);

	/**
	 * Method to approve a student
	 */
	public void approveStudent(String studentId);

	/**
	 * Method to add courses in the catalog
	 */
	public void addCourse(int courseID, String courseName, int instructorID, Integer semester, Integer seatsAvailable);

	/**
	 * Method to delete courses in the catalog
	 */
	public void deleteCourse(String courseID);

	/**
	 * Method to generate students' grade card
	 */
	public void generateGradeCard();
	
}
