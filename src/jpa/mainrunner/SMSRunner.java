package jpa.mainrunner;

import java.util.Scanner;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {
	static StudentService appS = new StudentService();
	static CourseService appC = new CourseService();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String [] args) {
		//placeholder
		run();
//		System.out.println(appS.getAllStudents());
		
	}
	
	public static void run() {
		int in = 0;
		while (in != 2) { 
			System.out.println("==== Student Management System ====\n\nSelect an option:\n1. Student Log-in\n2. Exit");
			in = sc.nextInt();
			System.out.println("== Log-In ==\nEnter your student email:");
			String logEmail = sc.next();
			System.out.println("Enter the password associated with your account:");
			String logPass = sc.next();
			
			if (appS.validateStudent(logEmail, logPass)) {
				appS.getStudentCourses(logEmail);
				internal();
				
			} else {
				System.out.println("Sorry, those credentials do not match a registered student account.");
				continue;
			}
		} 
		System.out.println("Goodbye...");
	}
	
	//method that runs if the student email / pass credential is validated
	public static void internal() {
		System.out.println("");
	}
}
