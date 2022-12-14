package gob.sbs.quarkus.panache;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import gob.sbs.quarkus.jdbc.Artist;
import gob.sbs.quarkus.panache.repository.ArtistRepository;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class PanacheRepositoryTest {

  @Inject
  ArtistRepository repository;

  @Test
  @TestTransaction
  public void shouldCreateAndFindArtist(){

    Artist artist = new Artist("name");

    assertFalse(repository.isPersistent(artist));
    repository.persist(artist);
    assertTrue(repository.isPersistent(artist));
    assertNotNull(artist.getId());

    artist = repository.findById(artist.getId());
    assertEquals("name", artist.getName());

    repository.deleteById(artist.getId());
    assertFalse(repository.isPersistent(artist));
  }
}
