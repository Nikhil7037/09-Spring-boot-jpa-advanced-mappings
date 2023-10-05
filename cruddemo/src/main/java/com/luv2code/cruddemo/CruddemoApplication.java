package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
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
		public CommandLineRunner commandLineRunner(AppDAO appDAO)
		{
			return runner->{
				//createInstructor(appDAO);
				findInstructor(appDAO);
			};
		}

	private void findInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id:"+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println(tempInstructor);
		System.out.println("the associated instructionDetail only"+tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor=new Instructor("Mary","Hupp","darby@luv2code.com");

		InstructorDetail tempInstructorDetail=new InstructorDetail("www.test.com","Luv2code");
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		System.out.println("Saving instructor"+tempInstructor);
		appDAO.save(tempInstructor);
	}
}


