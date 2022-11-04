package gob.sbs.quarkus.panache.repository;

import gob.sbs.quarkus.jdbc.Artist;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArtistRepository implements PanacheRepository<Artist> {

  public List<Artist> listAllArtistsSorted(){
    return listAll(Sort.descending("name"));
  }
}
