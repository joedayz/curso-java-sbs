package pe.joedayz.samples;

import jakarta.enterprise.inject.Produces;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Logger;

public class MessageWriterProducerField {

  private static Logger LOGGER = Logger.getLogger(MessageWriterProducerField.class.getName());
  private final static String HOME_PATH = "/tmp/";
  private final static String NAME_PATTERN = "MESSAGE_%d.txt";


  @Produces
  @MessageField
  MessageWriter messageWriter;

  public MessageWriterProducerField() {
    String fileName = String.format(NAME_PATTERN, Timestamp.valueOf(LocalDateTime.now()).getTime());
    LOGGER.info("Creating file message via producer field: " + HOME_PATH + fileName);

    this.messageWriter =new MessageWriter (HOME_PATH + fileName);
  }
}
