package pe.joedayz.jpademo.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import pe.joedayz.jpademo.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  User findByUsername(String username);
}
