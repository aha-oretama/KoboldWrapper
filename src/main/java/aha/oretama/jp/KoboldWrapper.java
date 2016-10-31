package aha.oretama.jp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KoboldWrapper {

  private StringBuilder command;

  public KoboldWrapper() {
    command = new StringBuilder("kobold");
  }

  public KoboldWrapper(String koboldPath) {
    command = new StringBuilder(koboldPath);
  }

  public void run(String path) throws IOException {
    if(!new File(path).exists()) {
      throw new IllegalArgumentException("Folder not exists.");
    }

    String com = execCommand(path);
    System.out.println(com);
    Process process = Runtime.getRuntime().exec(com);
    InputStream inputStream = process.getInputStream();
    InputStream errorStream = process.getErrorStream();

    try(BufferedReader reader = new BufferedReader(new InputStreamReader((inputStream)))){

      String line;
      while((line = reader.readLine()) != null){
        System.out.println(line);
      }
    }finally {
      if(inputStream != null) {
        inputStream.close();
      }
    };

    try(BufferedReader reader = new BufferedReader(new InputStreamReader((errorStream)))){

      String line;
      while((line = reader.readLine()) != null){
        System.out.println(line);
      }
    }finally {
      if(errorStream != null) {
        inputStream.close();
      }
    };

  }

  private String execCommand(String path){
    return command.append(" ").append(path).toString();
  }

  public KoboldWrapper approved(String path){
    command.append(" --approved-folder ").append(path);
    return this;
  }

  public KoboldWrapper build(String path){
    command.append(" --build-folder ").append(path);
    return this;
  }

  public KoboldWrapper highlight(String path){
    command.append(" --highlight-folder ").append(path);
    return this;
  }

  public KoboldWrapper config(String path) {
    command.append(" --config-folder ").append(path);
    return this;
  }

  public KoboldWrapper failOrphans() {
    command.append(" --fail-orphans");
    return this;
  }

  public KoboldWrapper failAdditios() {
    command.append(" --fail-additions");
    return this;
  }

}
