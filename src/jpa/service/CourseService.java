package jpa.service;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import jpa.dao.CourseDAOI;
import jpa.dbconnection.DBConnection;
import jpa.entitymodels.Course;

public class CourseService extends DBConnection implements CourseDAOI {
	
	@Override
	public List<Course> getAllCourses() {
		try {
			this.connect();
			Query q = em.createQuery("SELECT * FROM course");
			
			List<Course> allCourses = q.getResultList();
			
			this.disconnect();
			
			return allCourses;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
