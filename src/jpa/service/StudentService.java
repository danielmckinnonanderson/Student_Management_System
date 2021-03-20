package jpa.service;

import java.util.List;

import javax.persistence.Query;

import jpa.dao.StudentDAOI;
import jpa.dbconnection.DBConnection;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService extends DBConnection implements StudentDAOI {
	
	static final String selectAllStudents = "SELECT s FROM Student s";
	static final String getStudentByEmail = "SELECT s FROM Student s WHERE email = :sEmail";
	static final String validateStudent = "SELECT s FROM Student s WHERE email = :sEmail AND password = :sPassword";
	
	static final String getStudentCourse = "";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {
		try {
			this.connect();

			List<Student> students = (List<Student>)em.createQuery(selectAllStudents).getResultList();

			this.disconnect();
			return students;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student getStudentByEmail(String sEmail) {
		try {
			this.connect();
			
//			Query q = em.createQuery(getStudentByEmail);
//			q.setParameter("sEmail", sEmail);
//			
//			Student foundStudent = (Student)q.getSingleResult(); 
			
			Student foundStudent = em.find(Student.class, sEmail);
			
			
			this.disconnect();
			return foundStudent;
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean validateStudent(String sEmail, String sPassword) {
		try {
			this.connect();
			
			Query q = em.createQuery(validateStudent);
			q.setParameter("sEmail", sEmail);
			q.setParameter("sPassword", sPassword);
			
			if (q.getSingleResult() != null) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	return false;
	}

	@Override
	public void registerStudentToCourse(String sEmail, int cId) {
		try {
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Course> getStudentCourses(String sEmail) {
		try {
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
