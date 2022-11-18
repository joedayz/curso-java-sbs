package pe.joedayz.samples.restclient;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;

public class UserService {

  private static final String TARGET_SERVICE = "http://127.0.0.1:8080/jakartarest/api/users";

  public UserDto findById(String id){
    Client client = ClientBuilder.newClient();
    UserDto user = client.target(TARGET_SERVICE+"/"+id).request(MediaType.APPLICATION_JSON)
        .get(UserDto.class);
    return user;
  }
}
