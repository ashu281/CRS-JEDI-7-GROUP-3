package com.flipkart.business;

import com.flipkart.bean.Student;
import com.flipkart.bean.Professor;

public interface AdminInterface {
	public void addProfessor();
	public void approveStudents();
	public void modifyCourses();
	public void generateGradeCard();
	
}
