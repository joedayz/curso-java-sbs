package pe.joedayz.samples.rest;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import java.util.Collections;

@Path("/users")
public class UserResource {


  // http://{host}:{port}/{context-root}/api/{resource-path}
  //ex: // http://localhost:8080/jakartarest/api/users
  @GET  // POST, PUT, DELETE, HEAD, OPTIONS, PATCH
  // @QueryParameter, @PathParameter, @Consumes, @Produces
  @Produces(APPLICATION_JSON)
  public Response list(){
    return Response.ok(Collections.EMPTY_LIST).build();
  }
}
