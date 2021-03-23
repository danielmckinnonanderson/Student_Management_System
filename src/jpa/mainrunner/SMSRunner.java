package jpa.mainrunner;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {
	static StudentService appS = new StudentService();
	static CourseService appC = new CourseService();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		run();
	}

	//outermost main entry point method, responsible for introductory menu and verifying log-in
	public static void run() {
		int in = 0;
		System.out.println("==== Student Management System ====");
		while (in != 2) {
			try {
				System.out.println("\nSelect an option:\n1. Student Log-in\n2. Exit");
				in = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Please select an option.");
				sc.next();
			}
			if (in == 1) {
				System.out.print("== Log-In ==\nEnter your student email:  ");
				String logEmail = sc.next();
				System.out.print("Enter the password associated with your account:  ");
				String logPass = sc.next();

				// if student is in system, proceed to internal (logged-in) method
				if (appS.validateStudent(logEmail, logPass)) {
					internal(logEmail, logPass);
				} else {
					continue;
				}
			}
		}
		System.out.println("Goodbye...");
	}

	// method that runs if the student email / pass credential is validated
	public static void internal(String email, String pass) {

		Student student = appS.getStudentByEmail(email);

		System.out.printf("\nWelcome, %s!\n\n", student.getsName());
		int studentChoice = 0;

		while (studentChoice != 2) {
			try {
				//displays courses the student is currently registered for
				System.out.println("Your registered courses:\n");
				appS.printCourses(appS.getStudentCourses(email));
				
				//displays student menu options
				internalMenu();

				studentChoice = sc.nextInt();
				
			} catch (InputMismatchException ime) {
				System.out.println("Please select an option.");
				sc.next();
			}
			//register student to course
			if (studentChoice == 1) {
				try {
					//show all available class option
					System.out.println("Select a course using the Course ID to register:");
					printEach(appC.getAllCourses());

					int courseChoice = sc.nextInt();
					//if option is valid choice, register student to course and continue loop
					appS.registerStudentToCourse(email, courseChoice);
					continue;
					
				} catch (InputMismatchException ime) {
					System.out.println("Please select a course by Course ID.\n");
					sc.next();
				} catch (Exception e) {
					System.out.println("Error registering class, please try again.\n");
					sc.next();
				}
			}
		}
		System.out.println("Successfully logged out.");
	}

	// this method runs at the beginning of the internal loop once a student has logged in
	public static void internalMenu() {
		System.out.println("\n== Student Services Menu: ==\n");
		System.out.println("1. Register to Class\n2. Log out\n");
	}

	// method for printing each item in list of objects
	public static <T> void printEach(List<T> items) {
		if (items != null) {
			for (T i : items) {
				System.out.println(i);
			}
		}
	}
}