package main;

import main.models.enums.CoffeeType;
import main.models.repositories.CoffeeRepository;
import main.models.repositories.ProductsRepository;
import main.models.tables.Coffee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;



@SpringBootApplication

public class LearningMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningMicroservicesApplication.class, args);
	}


	//Fast way to declare beans (commented since we don't need test data to add manually anymore)
	//now it serves only as an example for learning purposes (as reference)

//	@Configuration
//	static
//	class LoadDatabase {
//
//		//command line runner means that the method will be invocated when the app is loaded
//		@Bean
//		CommandLineRunner testDB(CoffeeRepository repository, ProductsRepository productsRepository) {
//			return args -> {
//				repository.save(new Coffee("Test coffee", CoffeeType.GRINDED, 123.12));
//				repository.save(new Coffee("Another coffee", CoffeeType.GRINDED, 432.12));
//				List<ProductsRepository.ProductNameAndId> test = productsRepository.findByNameLike("%TES%");
//				for(ProductsRepository.ProductNameAndId ex : test) {
//					System.out.println(ex.toString());
//				}
//			};
//		}
//	}
}
