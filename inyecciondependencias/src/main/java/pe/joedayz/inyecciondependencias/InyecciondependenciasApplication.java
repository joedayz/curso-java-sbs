package pe.joedayz.inyecciondependencias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"",""})
public class InyecciondependenciasApplication {

	public static void main(String[] args) {
		SpringApplication.run(InyecciondependenciasApplication.class, args);
	}

}
