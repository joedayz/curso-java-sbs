package pe.joedayz.samples;

import jakarta.enterprise.event.Observes;
import jakarta.enterprise.event.ObservesAsync;
import java.util.logging.Logger;

public class EmailObserver {

  private final static Logger LOGGER = Logger.getLogger(EmailObserver.class.getName());

  public void send(@Observes Email email){
    this.sendEmail(email);
  }

  public void sendAsync(@ObservesAsync Email email){
    this.sendEmail(email);
  }

  private void sendEmail(Email email) {
    LOGGER.info("Email: "+ email.getSubject().orElse("")
    + " sent from: " + email.getFrom()
    + " to: "+ email.getTo());
  }
}
