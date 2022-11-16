package pe.joedayz.samples;

import static java.lang.String.format;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.logging.Logger;


@Interceptor
@Auditoring
public class AuditoringInterceptor implements Serializable {

  private final Logger LOGGER = Logger.getLogger(AuditoringInterceptor.class.getName());

  private final String PATTERN_AUDIT = "username:%s ; class called:%s; method called:%s";

  @Inject
  private HttpServletRequest request;

  @AroundInvoke
  public Object intercept(InvocationContext invocationContext) throws Exception {
    String username = (String) request.getSession().getAttribute("username");
    String className = invocationContext.getTarget().getClass().getName();
    String methodName = invocationContext.getMethod().getName();
    if(username==null){
      LOGGER.info(format(PATTERN_AUDIT, "anonymous", className, methodName));
    }else{
      LOGGER.info(format(PATTERN_AUDIT, username, className, methodName));
    }

    return invocationContext.proceed();
  }
}
