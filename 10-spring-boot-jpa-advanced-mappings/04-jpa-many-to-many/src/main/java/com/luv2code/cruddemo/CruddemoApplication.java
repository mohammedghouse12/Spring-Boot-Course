package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			createCourseAndStudents(appDAO);

//			findCourseAndStudents(appDAO);

//			findStudentAndCourses(appDAO);

//			addMoreCoursesForStudent(appDAO);

//			deleteCourse(appDAO);

			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int id = 2;
		appDAO.deleteStudentById(id);
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int id = 2;
		Student student = appDAO.findStudentAndCoursesByStudentId(id);

		Course physics = new Course("Physics");
		Course chemistry = new Course("Chemistry");
		student.addCourse(physics);
		student.addCourse(chemistry);

		appDAO.update(student);
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int id = 1;
		Student student = appDAO.findStudentAndCoursesByStudentId(id);
		System.out.println(student);
		List<Course> courses = student.getCourses();
		for(Course course: courses)
			System.out.println(course);
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseAndStudentsByCourseId(id);
		System.out.println(course);
		List<Student> students = course.getStudents();
		for(Student student: students)
			System.out.println(student);
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course course = new Course("Math");

		Student ghouse = new Student("Mohammed", "Ghouse", "ghouse@gmail.com");
		Student ayush = new Student("Ayush", "Jef", "ayush@gmail.com");
		Student harsh = new Student("Harsh", "Kumar", "harsh@gmail.com");

		course.addStudent(ghouse);
		course.addStudent(ayush);
		course.addStudent(harsh);

		appDAO.save(course);
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 10;
		appDAO.deleteCourse(id);
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		appDAO.deleteInstructor(2);
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseById(id);
		System.out.println(course);
		course.setTitle("Math");
		System.out.println(course);
		appDAO.updateCourse(course);
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;

		Instructor instructor = appDAO.findInstructorById(id);
		instructor.setFirstName("Shaik");

		appDAO.updateInstructor(instructor);

		instructor = appDAO.findInstructorById(id);
		System.out.println(instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(1);
		System.out.println(instructor);
		System.out.println(instructor.getInstructorDetail());
		System.out.println(instructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println(instructor);

		List<Course> courses = appDAO.findCoursesByInstructorId(id);

		instructor.setCourses(courses);

		System.out.println("Courses: "+instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor =
			new Instructor("Mohammed", "Ghouse", "ghouse@gmail.com");

		InstructorDetail instructorDetail =
			new InstructorDetail("MrMohammed", "Nothing");

		instructor.setInstructorDetail(instructorDetail);

		instructor.add(new Course("Math"));
		instructor.add(new Course("Physics"));
		instructor.add(new Course("Chemistry"));

		appDAO.save(instructor);

		System.out.println(instructor);

		for(Course course: instructor.getCourses())
			System.out.println(course);

		System.out.println();
	/* ----------------------------------------------------------------------------------------*/

		instructor =
				new Instructor("Ayush", "Jef", "ayush@gmail.com");
		instructorDetail =
				new InstructorDetail("MrAyush", "Coding");

		instructor.setInstructorDetail(instructorDetail);

		instructor.add(new Course("Biology"));
		instructor.add(new Course("Botany"));
		instructor.add(new Course("Zoology"));

		appDAO.save(instructor);

		System.out.println(instructor);

		for(Course course: instructor.getCourses())
			System.out.println(course);

		System.out.println();

	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleting instructor detail with id: "+id);
		appDAO.deleteInstructorDetailById(id);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 1;
		System.out.println("Fetching Instructor Details of id: "+id);
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("Instructor Details: "+instructorDetail);
		Instructor instructor = instructorDetail.getInstructor();
		System.out.println("Associated Instructor: "+instructor);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO){
		int id = 1;
		System.out.println("Finding instructor with id: "+id);
		Instructor	instructor= appDAO.findInstructorById(id);
		System.out.println("Instructor found: "+instructor);
		System.out.println("Instructor details only: " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
//		Instructor instructor =
//				new Instructor("Mohammed", "Ghouse", "ghouse@gmail.com");
//		InstructorDetail instructorDetail =
//				new InstructorDetail("MrMohammed", "Nothing");

		Instructor instructor =
				new Instructor("Ayush", "Jef", "ayush@gmail.com");
		InstructorDetail instructorDetail =
				new InstructorDetail("MrAyush", "Coding");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: "+instructor);
		appDAO.save(instructor);

		System.out.println("Done!");
	}
}
