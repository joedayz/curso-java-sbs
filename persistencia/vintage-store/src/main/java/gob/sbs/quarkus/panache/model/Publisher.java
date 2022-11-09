package gob.sbs.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_publishers")
public class Publisher extends PanacheEntity {

  @Column(length = 50, nullable = false)
  public String name;

  @Column(name = "created_date", nullable = false)
  public Instant createdDate = Instant.now();

  public Publisher(String name) {
    this.name = name;
  }

  public Publisher() {
  }

  // ======================================
  // =              Methods               =
  // ======================================

  public static List<Publisher> findContainingName(String name) {
    return Publisher.list("name like ?1", "%" + name + "%");
  }

  public static Optional<Publisher> findByName(String name) {
    return Publisher.find("name", name).firstResultOptional();
  }

  @Override
  public String toString() {
    return "Publisher{" +
        "name='" + name + '\'' +
        ", createdDate=" + createdDate +
        ", id=" + id +
        '}';
  }
}
