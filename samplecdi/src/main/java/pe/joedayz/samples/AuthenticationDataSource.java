package pe.joedayz.samples;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class AuthenticationDataSource implements Serializable {

  private Map<String, String> userDataSource;

  @PostConstruct
  public void init(){
    userDataSource = new ConcurrentHashMap<>();
    userDataSource.put("admin", "admin");
    userDataSource.put("joe", "joe");
  }

  public boolean validate(String username, String password){
    if(username==null || password==null){
      return false;
    }
    if(Objects.equals(userDataSource.get(username), password)){
      return true;
    }
    return false;
  }
}
