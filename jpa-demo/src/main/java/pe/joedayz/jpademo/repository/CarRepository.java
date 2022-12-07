package pe.joedayz.jpademo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pe.joedayz.jpademo.domain.Car;

import org.springframework.data.repository.CrudRepository;


@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {

  List<Car> findByBrand(@Param("brand") String brand);

  List<Car> findByColor(@Param("color") String color);
//
//  List<Car> findByBrandOrderByYearAsc(String brand);
//
//  @Query("select c from Car c where c.brand = ?1")
//  List<Car> getListByBrand(String brand);
//
//  @Query("select c from Car c where c.brand like %?1")
//	List<Car> findByBrandEndsWith(String brand);


}
