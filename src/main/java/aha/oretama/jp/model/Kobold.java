package aha.oretama.jp.model;

import lombok.Value;

import java.util.List;

@Value
public class Kobold {

  private List<String> additions;
  private List<String> orphans;
  private List<String> differences;

}
