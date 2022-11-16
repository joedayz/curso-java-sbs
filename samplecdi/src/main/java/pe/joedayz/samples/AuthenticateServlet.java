package pe.joedayz.samples;

import static jakarta.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static jakarta.servlet.http.HttpServletResponse.SC_FORBIDDEN;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authenticate")
public class AuthenticateServlet extends HttpServlet {

  @Inject
  private AuthenticationDataSource authenticationDataSource;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    if(username==null || password==null){
      resp.sendError(SC_BAD_REQUEST);
      return;
    }

    if(authenticationDataSource.validate(username, password)){
      req.getSession().setAttribute("username", username);
    }else{
      resp.sendError(SC_FORBIDDEN);
    }

  }
}
