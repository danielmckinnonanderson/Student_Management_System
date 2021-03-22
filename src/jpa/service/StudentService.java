package jpa.service;

import java.util.List;

import javax.persistence.Query;

import jpa.dao.StudentDAOI;
import jpa.dbconnection.DBConnection;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService extends DBConnection implements StudentDAOI {
	
	static final String selectAllStudents = "SELECT s FROM Student s";

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		try {
			this.connect();

			List<Student> students = (List<Student>) em.createQuery(selectAllStudents).getResultList();

			this.disconnect();
			return students;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Student getStudentByEmail(String sEmail) {
		try {
			this.connect();

			Student foundStudent = em.find(Student.class, sEmail);

			this.disconnect();
			return foundStudent;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean validateStudent(String sEmail, String sPassword) {
		try {
			//locate student with matching email in database
			if ((sEmail != null) && (sPassword != null)) {
				Student foundStudent = getStudentByEmail(sEmail);
				this.connect();
				if (foundStudent != null) {
					//check if the password entered matches the password stored for retrieve student
					if (foundStudent.getsPass().equals(sPassword)) {
						this.disconnect();
						return true;
					} else {
						System.out.println("Password is incorrect for specified student email");
						this.disconnect();
						return false;
					}
				} else {
					System.out.println("No student is registered under that email!");
					this.disconnect();
					return false;
				}
			} else {
				System.out.println("Please enter a valid email and password!");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.disconnect();
		return false;
	}


	public void registerStudentToCourse(String sEmail, int cId) {
		try {
			this.connect();
			//find student and course with specified attributes
			Student foundStudent = em.find(Student.class, sEmail);
			Course selectedCourse = em.find(Course.class, cId);
			@SuppressWarnings("unchecked")
			List<Course> courses = foundStudent.getsCourses();
			
			//check if student is already registered for specified course
			if (courses.contains(selectedCourse)) {
				System.out.println("\nStudent is already registered for this course!\n");
				this.disconnect();
				
			} else {
				/*if not already registered, add course to 
				 student's course list*/
				this.em.getTransaction().begin();
				
				courses.add(selectedCourse);
				foundStudent.setsCourses(courses);
				//push update of row to database
				this.em.merge(foundStudent);
				
				this.em.getTransaction().commit();
				
				System.out.println("Successfully registered for " + selectedCourse.getcName() + " with "
						+ selectedCourse.getcInstructorName());
				this.disconnect();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Course> getStudentCourses(String sEmail) {
		try {
			this.connect();
			//locate student by specified email
			Student foundStudent = getStudentByEmail(sEmail);
			if (foundStudent.getsCourses() != null) {
				//return specified students course list
				return foundStudent.getsCourses();
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
    public <T> void printCourses(List<T> sCourses) {
    	if (sCourses != null) {
    		System.out.printf("%-3s %-28s %-18s\n", "ID", "COURSE NAME", "INSTRUCTOR NAME");
    		//for each course object in course list, print course object row
    		for (T course : sCourses) {
    			System.out.println(course);
    		}
    	}
    }
}