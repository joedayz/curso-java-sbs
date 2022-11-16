package pe.joedayz.samples;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class MessageWriter implements Serializable {

  private File file;


  public MessageWriter(String path) {
    this.file = new File(path);
  }

  public void add(String message){

    try(BufferedWriter outputStream = new BufferedWriter(new FileWriter(file, true))){
      outputStream.write(message);
      outputStream.newLine();
    }catch(FileNotFoundException e){
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void clean(){
    file.delete();
  }
}
