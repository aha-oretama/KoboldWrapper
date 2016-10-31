package aha.oretama.jp.mapper;

import aha.oretama.jp.model.Kobold;

import java.io.InputStream;

public class IOKoboldMapper {

  private InputStream ioStream;
  private InputStream errorStream;

  public IOKoboldMapper(InputStream ioStream, InputStream errorStream){
    this.ioStream = ioStream;
    this.errorStream = errorStream;
  }

  public Kobold getKobold(){
    return new Kobold();
  }


}
