package gob.sbs.quarkus.panache.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import gob.sbs.quarkus.jdbc.Artist;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ArtistRepositoryTest {

  @Inject
  ArtistRepository repository;

  @Test
  @TestTransaction
  public void shouldCreateAndFindAnArtist() {
    long count = repository.count();
    int listAll = repository.listAll().size();
    assertEquals(count, listAll);
    assertEquals(repository.listAllArtistsSorted().size(), listAll);

    // Creates an Artist
    Artist artist = new Artist();
    artist.setName("name");
    artist.setBio("bio");

    repository.persist(artist);
    assertNotNull(artist.getId());

    assertEquals(count + 1, repository.count());


    // Gets the Artists
    artist = repository.findById(artist.getId());
    assertEquals("name", artist.getName());

    // Deletes the Artist
    repository.deleteById(artist.getId());
    assertEquals(count, repository.count());
  }
}
