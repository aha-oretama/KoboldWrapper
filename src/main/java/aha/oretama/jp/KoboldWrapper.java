package aha.oretama.jp;

import aha.oretama.jp.mapper.IOKoboldMapper;
import aha.oretama.jp.model.Kobold;

import java.io.File;
import java.io.IOException;

public class KoboldWrapper {

  private StringBuilder command;
  private boolean fileExtensions = false;

  public KoboldWrapper() {
    command = new StringBuilder("kobold");
  }

  public KoboldWrapper(String koboldPath) {
    command = new StringBuilder(koboldPath);
  }

  public Kobold run(String path) throws IOException {
    if(!new File(path).exists()) {
      throw new IllegalArgumentException("Folder not exists.");
    }

    Process process = Runtime.getRuntime().exec(execCommand(path));
    return new IOKoboldMapper(process.getInputStream(), process.getErrorStream(), fileExtensions).getKobold();
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

  public KoboldWrapper addFileExtentions(boolean fileExtensions) {
    this.fileExtensions = fileExtensions;
    return this;
  }

}
