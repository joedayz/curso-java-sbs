package pe.joedayz.jpademo;

import pe.joedayz.jpademo.domain.Car;
import pe.joedayz.jpademo.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaDemoApplication {

	@Autowired
	private CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
		carRepository.save(new Car("Ford", "Mustang", "Red",
				"AKG247", 2019, 59000));

		};
	}
}

