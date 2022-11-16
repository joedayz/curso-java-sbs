package pe.joedayz.samples;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("messages")
public class MessageServlet extends HttpServlet {

  @Inject
  //@Message
  @MessageField
  private MessageWriter messageWriter;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String message = req.getParameter("message");
    if(Objects.nonNull(message) && !message.isEmpty()){
      messageWriter.add(message);
    }
    resp.getWriter().println("Message added: " + message);
  }
}
