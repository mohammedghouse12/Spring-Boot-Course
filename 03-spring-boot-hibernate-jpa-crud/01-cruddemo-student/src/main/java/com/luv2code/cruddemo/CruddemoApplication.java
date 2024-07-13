package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.dao.StudentDAOImpl;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner->{
//			createStudent(studentDAO);

//			createMultipleStudents(studentDAO);

//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			updateAllStudents(studentDAO);

//			deleteStudent(studentDAO);

//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int rowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted " + rowsDeleted + " students");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int sutdentId = 4;
		System.out.println("Deleting student id: " + sutdentId);
		studentDAO.delete(sutdentId);
	}

	private void updateAllStudents(StudentDAO studentDAO) {
		String lastName = "Legend";

		System.out.println("Changing lastName of all the entries to: "+ lastName);
		int rowsEffected = studentDAO.updateAll(lastName);

		System.out.println("Rows effected: " + rowsEffected);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;

		System.out.println("Fetching student with studentId: " + studentId);
		Student student = studentDAO.findById(studentId);

		System.out.println("Details found: " + student);

		System.out.println("Updating student lastName to: " + "Kumar");
		student.setLastName("Kumar");
		studentDAO.update(student);

		System.out.println("Fetching student with studentId: " + studentId);
		student = studentDAO.findById(studentId);
		System.out.println("Details found: " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Kumar");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get list of students
		List<Student> students = studentDAO.findAll();

		//display each student from retrieved list
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating a new student");
		Student student = new Student("dipak", "bhandare", "diapkb@gmail.com");

		System.out.println("Saving the student");
		studentDAO.save(student);

		int theId = student.getId();
		System.out.println("ID Generated: " + theId);

		System.out.println("Retrieving the student via Id");
		Student myStudent = studentDAO.findById(theId);

		System.out.println("Student retrieved: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating three student objects...");
		Student student1 = new Student("Harsh", "Kumar", "harsh@gmail.com");
		Student student2 = new Student("Ayush", "Jef", "jef@gmail.com");
		Student student3 = new Student("Kiran", "Kumar", "kiran@gmail.com");

		//save the student objects
		System.out.println("Saving three students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student student = new Student("Mohammed", "Ghouse", "ghouse@gmail.com");

		System.out.println("Saving student...");
		studentDAO.save(student);

		System.out.println("Saved Student, fetching student ID");
		System.out.println("Student Id: " + student.getId());
	}

}
