package aha.oretama.jp;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class KoboldWrapperTest {

  @Before
  public void before() {
    deleteFilesInFolder("examples/highlight");
    deleteFilesInFolder("examples/highlightTest");
  }

  @Test
  public void run() throws Exception {
    new KoboldWrapper().run("examples");

    File file = new File("examples/highlight/YDN_Color.png");
    assertTrue(file.exists());
  }

  @Test
  public void test_runWithHighlight() throws Exception {
    new KoboldWrapper().highlight("highlightTest").run("examples");

    File file = new File("examples/highlightTest/YDN_Color.png");
    assertTrue(file.exists());
  }

  @Test
  public void test_runWithOrphans() throws Exception {
    new KoboldWrapper().failOrphans().failAdditios().run("examples");

    File file = new File("examples/highlight/YDN_Color.png");
    assertTrue(file.exists());
  }

  private void deleteFilesInFolder(String path){
    File folder = new File(path);
    if(!folder.isDirectory() || folder.listFiles() == null) {
      return;
    }

    List<File> files = Arrays.asList(folder.listFiles());

    for (File file : files) {
      file.delete();
    }

  }

}
