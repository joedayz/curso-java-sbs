package pe.joedayz.samples;

import static jakarta.servlet.http.HttpServletResponse.SC_FORBIDDEN;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/seguro")
public class ServletSeguro extends HttpServlet {


  @Inject
  private BeanSeguro beanSeguro;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String username = (String)req.getSession().getAttribute("username");
    try{
      resp.getWriter().println(beanSeguro.generateText(username));
    } catch (AuthenticationException e) {
      resp.sendError(SC_FORBIDDEN);
      e.printStackTrace();
    }
  }
}
