package pe.joedayz.samples;

import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/email")
public class EmailServlet extends HttpServlet {

  private final static Logger LOGGER = Logger.getLogger(EmailServlet.class.getName());

  @Inject
  private Event<Email> emailEvent;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String from = req.getParameter("from");
    String to = req.getParameter("to");

    if(from==null || from.isEmpty() || to == null || to.isEmpty()){
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }

    String subject = req.getParameter("subject");
    String message = req.getParameter("message");
    String async = req.getParameter("async");

    if("true".equals(async)){
      emailEvent.fireAsync(Email.of(from, to, subject, message));
      LOGGER.info("Async event sent");
    }else{
      emailEvent.fire(Email.of(from, to, subject, message));
      LOGGER.info("Sync event sent");
    }
  }
}
