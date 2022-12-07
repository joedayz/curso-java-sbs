package pe.joedayz.cardatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarDatabaseDemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(CarDatabaseDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarDatabaseDemoApplication.class, args);
		logger.info("Hola Spring Boot");  //TRACE, DEBUG, WARN, ERROR, FATAL, OFF
	}

}
