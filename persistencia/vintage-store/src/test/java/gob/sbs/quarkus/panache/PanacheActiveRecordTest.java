package gob.sbs.quarkus.panache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import gob.sbs.quarkus.panache.model.Publisher;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class PanacheActiveRecordTest {

  @Test
  @TestTransaction
  public void shouldCreateAndFindAPublisher() {
    Publisher publisher = new Publisher("name");

    assertFalse(publisher.isPersistent());
    Publisher.persist(publisher);
    assertTrue(publisher.isPersistent());
    assertNotNull(publisher.id);

    publisher = Publisher.findById(publisher.id);
    assertEquals("name", publisher.name);

    Publisher.deleteById(publisher.id);
    assertFalse(publisher.isPersistent());

  }
}
