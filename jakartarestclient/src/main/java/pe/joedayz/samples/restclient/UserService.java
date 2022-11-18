package pe.joedayz.samples.restclient;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class UserService {

  private static final String TARGET_SERVICE = "http://127.0.0.1:8080/jakartarest/api/users";

  public UserDto findById(String id){
    Client client = ClientBuilder.newClient();
    UserDto user = client.target(TARGET_SERVICE+"/"+id).request(MediaType.APPLICATION_JSON)
        .get(UserDto.class);
    // Builder.post()
    // Builder.head()
    // Builder.put()
    // Builder.delete()
    // Builder.options()
    // Builder.trace()
    // Builder.patch()
    return user;
  }

  public boolean save(UserDto user) {
    Form form = new Form();
    form.param("name", user.getName());
    form.param("email", user.getEmail());

    Client client = ClientBuilder.newClient();
    Response response = client.target(TARGET_SERVICE+"/").request().post(Entity.form(form));
    return response.getStatus() == Status.CREATED.getStatusCode();
  }
}
