package pe.joedayz.jpademo.repository;

import pe.joedayz.jpademo.domain.Car;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
