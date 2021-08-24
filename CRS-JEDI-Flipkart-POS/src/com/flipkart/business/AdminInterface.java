package com.flipkart.business;

import com.flipkart.bean.Student;
import com.flipkart.bean.Professor;

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
	public void addProfessor();

	/**
	 * Method to approve a student
	 */
	public void approveStudent(String studentId);

	/**
	 * Method to add courses in the catalog
	 */
	public void addCourse(Course course);

	/**
	 * Method to delete courses in the catalog
	 */
	public void deleteCourse(String courseID);

	/**
	 * Method to generate students' grade card
	 */
	public void generateGradeCard();
	
}
