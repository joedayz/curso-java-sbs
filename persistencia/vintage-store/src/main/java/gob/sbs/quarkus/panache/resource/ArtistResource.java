package gob.sbs.quarkus.panache.resource;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import gob.sbs.quarkus.jdbc.Artist;
import gob.sbs.quarkus.panache.repository.ArtistRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/artists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional(SUPPORTS)
public class ArtistResource {

  @Inject
  ArtistRepository repository;

  /**
   * curl http://localhost:8080/api/artists
   */
  @GET
  public List<Artist> listAllArtists(){
    return repository.listAllArtistsSorted();
  }
}
