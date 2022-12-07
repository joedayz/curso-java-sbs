package pe.joedayz.inyecciondependencias.components;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

	@Autowired
	private Owner owner;

	@Autowired
	private CarRepository carRepository;

	//@Resource
	@Resource(name="configFile")
	private File configFile;

//	public Car(Owner owner){
//		this.owner = owner;
//	}

//	public void setOwner(Owner owner){
//		this.owner = owner;
//	}
}
