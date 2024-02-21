package com.example.SrpingJDBCProject;

import com.example.SrpingJDBCProject.model.Alien;
import com.example.SrpingJDBCProject.repo.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcProjectApplication {

	public static void main(String[] args) {

		ApplicationContext context  =	SpringApplication.run(SpringJdbcProjectApplication.class, args);

		Alien alien = context.getBean(Alien.class);
		alien.setId(119);
		alien.setName("Ansh");
		alien.setTech("Spring Boot");

		AlienRepo alienRepo = context.getBean(AlienRepo.class);
		alienRepo.save(alien);

		System.out.println(alienRepo.getAliens());

	}

}
