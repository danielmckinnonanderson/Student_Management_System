package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public interface StudentDAOI {
	abstract List<Student> getAllStudents();
	abstract Student getStudentByEmail(String sEmail);
	abstract boolean validateStudent(String sEmail, String sPassword);
	abstract void registerStudentToCourse(String sEmail, int cId);
	abstract List<Course> getStudentCourses(String sEmail);
}
