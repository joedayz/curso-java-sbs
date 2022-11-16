package pe.joedayz.samples;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Interceptor
@Authentication
public class AuthenticationInterceptor implements Serializable {

  @Inject
  private HttpServletRequest request;

  @AroundInvoke
  public Object intercept(InvocationContext invocationContext) throws Exception {
    String username = (String) request.getSession().getAttribute("username");

    if(username==null){
      throw new AuthenticationException("User is not authenticated");
    }

    return invocationContext.proceed();
  }
}
