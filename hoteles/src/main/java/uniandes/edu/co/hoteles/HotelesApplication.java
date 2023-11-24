package uniandes.edu.co.hoteles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "uniandes.edu.co.hoteles.repository")
public class HotelesApplication{

	public static void main(String[] args) {
		SpringApplication.run(HotelesApplication.class, args);
	}

	

}
