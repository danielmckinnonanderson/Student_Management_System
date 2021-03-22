package jpa.service;

import java.util.List;

import jpa.dao.CourseDAOI;
import jpa.dbconnection.DBConnection;
import jpa.entitymodels.Course;

public class CourseService extends DBConnection implements CourseDAOI {
	
	static final String selectAllCourses = "SELECT c FROM Course c";
	
	@Override
	public List<Course> getAllCourses() {
		try {
			this.connect();
			
			@SuppressWarnings("unchecked")
			List<Course> allCourses = em.createQuery(selectAllCourses).getResultList();
			
			this.disconnect();
			
			return allCourses;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
