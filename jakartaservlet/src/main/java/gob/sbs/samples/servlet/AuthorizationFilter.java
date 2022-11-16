package gob.sbs.samples.servlet;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebFilter("/security/*")
public class AuthorizationFilter implements Filter {

  private Map<String, String> passwords;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    passwords = new ConcurrentHashMap<>();
    passwords.put("admin", "admin");
    passwords.put("developer", "dev123");
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {

    if(!validateAuth((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse)){
      ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized request");
    }else{
      filterChain.doFilter(servletRequest, servletResponse);
    }
  }

  private boolean validateAuth(HttpServletRequest request, HttpServletResponse servletResponse) {
    String login = request.getParameter("login");
    if(login==null || !passwords.containsKey(login)){
      return false;
    }
    String password = request.getParameter("password");
    if(password==null || !passwords.get(login).equals(password)){
      return false;
    }
    return true;
  }
}
