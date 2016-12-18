package aha.oretama.jp.mapper;

import aha.oretama.jp.model.Kobold;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IOKoboldMapper {

  private String ioString;
  private String errorString;
  private boolean fileExtensions = false;

  private static final String FILE_EXTENSTION = ".png";
  private static final String ENCODING = "UTF-8";

  public IOKoboldMapper(InputStream ioStream, InputStream errorStream, boolean fileExtensions) {

    this.fileExtensions = fileExtensions;
    try {
      this.ioString = IOUtils.toString(ioStream, ENCODING);
      this.errorString = IOUtils.toString(errorStream, ENCODING);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  public Kobold getKobold(){
    return new Kobold(getAdditions(),getOrphans(),getDifferences());
  }

  private List<String> getAdditions() {
    return getMatchList("Error:\\sScreen\\sis\\snew:\\s(\\S+)\\e\\[0m");
  }

  private List<String> getOrphans() {
    return getMatchList("Error:\\sApproved\\sscreen\\sis\\sorphaned:\\s(\\S+)\\e\\[0m");
  }

  private List<String> getDifferences() {
    return getMatchList("Error:\\sScreens\\sare\\sdifferent\\sfor\\s(\\S+)\\e\\[0m");
  }

  private List<String> getMatchList(String regex) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(errorString);

    List<String> matchList = new ArrayList<>();
    while(matcher.find()) {
      matchList.add(fileExtensions ? matcher.group(1) + FILE_EXTENSTION : matcher.group(1));
    }

    return matchList;

  }
}
