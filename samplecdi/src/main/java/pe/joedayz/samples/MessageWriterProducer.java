package pe.joedayz.samples;


import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Logger;

public class MessageWriterProducer {

  private static Logger LOGGER = Logger.getLogger(MessageWriterProducer.class.getName());
  private final static String HOME_PATH = "/tmp/";
  private final static String NAME_PATTERN = "MESSAGE_%d.txt";

  @Produces
  @Message
  public MessageWriter build(){
    String fileName = String.format(NAME_PATTERN, Timestamp.valueOf(LocalDateTime.now()).getTime());
    LOGGER.info("Creating file message via producer method: " + HOME_PATH + fileName);

    return new MessageWriter(HOME_PATH + fileName);
  }

  public void clean(@Disposes @Message MessageWriter messageWriter){
    LOGGER.info("Removing file message");
    messageWriter.clean();
  }

}
