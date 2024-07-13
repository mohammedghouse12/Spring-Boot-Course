package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			createInstructor(appDAO);

//			findInstructor(appDAO);

//			deleteInstructor(appDAO);

//			findInstructorDetail(appDAO);

			deleteInstructorDetail(appDAO);
		};
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

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleting instructor with id: "+id);
		appDAO.deleteInstructorById(id);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO){
		int id = 2;
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
