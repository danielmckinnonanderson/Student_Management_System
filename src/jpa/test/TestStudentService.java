package jpa.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import jpa.service.StudentService;


public class TestStudentService {
	
	static StudentService appS;

	
	@BeforeClass
	public static void setUp() {
		appS = new StudentService();
	}
	
	//ILLEGAL STATE EXCEPTION
	@Test
	public void testValidateStudent1() {
		assertEquals(true, appS.validateStudent("aiannitti7@is.gd", "TWP4hf5j"));
	}
	
	//ILLEGAL STATE EXCEPTION
	@Test
	public void testValidateStudent2() {
		assertEquals(true, appS.validateStudent("qllorens2@howstuffworks.com", "W6rJuxd"));
	}
	
	//ILLEGAL STATE EXCEPTION
	@Test
	public void testValidateStudent3() {
		assertEquals(false, appS.validateStudent("notinsystem@gmail.com", "wrong"));
	}
	
	//PASSED
	@Test
	public void testValidateStudent4() {
		assertEquals(false, appS.validateStudent(null, null));
	}
}
