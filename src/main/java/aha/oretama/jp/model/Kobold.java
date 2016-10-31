package aha.oretama.jp.model;

import lombok.Data;

import java.util.List;

@Data
public class Kobold {

  private List<String> additions;
  private List<String> orphans;
  private List<String> differences;
}
