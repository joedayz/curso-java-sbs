package pe.joedayz.samples;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BeanSeguro {

  @Authentication
  @Auditoring
  public String generateText(String username) throws AuthenticationException{
      return "Welcome " + username;
  }

}
