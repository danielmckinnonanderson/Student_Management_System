package jpa.dao;

import java.util.List;
import jpa.entitymodels.Course;

public interface CourseDAOI {
	abstract List<Course> getAllCourses();
}
