package com.createms.learningmicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class LearningMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningMicroservicesApplication.class, args);
	}


	//Fast way to declare beans (commented since we don't need test data to add manually anymore)
	//now it serves only as an example for learning purposes (as reference)
//	@Configuration
//
//	class LoadDatabase {
//
//		//command line runner means that the method will be invocated when the app is loaded
//		@Bean
//		CommandLineRunner testDB(TeaRepository repository) {
//			return args -> {
//				repository.save(new Tea("Test", TeaType.PACKAGED, 212.1));
//				repository.save(new Tea("Test2", TeaType.LOOSE, 1234521.1));
//			};
//		}
//	}
}
