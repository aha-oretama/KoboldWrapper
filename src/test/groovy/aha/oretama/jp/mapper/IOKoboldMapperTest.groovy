package aha.oretama.jp.mapper

import aha.oretama.jp.model.Kobold
import spock.lang.Specification

/**
 * @author sekineyasufumi on 2016/11/01.
 */
class IOKoboldMapperTest extends Specification {

  private static final String INPUT = "src/test/resources/iodata/io.txt"
  private static final String ERROR = "src/test/resources/iodata/error.txt"


  def 'getAdditions'() {
    setup:
    IOKoboldMapper mapper = new IOKoboldMapper(new FileInputStream(new File(INPUT)), new FileInputStream(new File(ERROR)), fileExtentions)
    List list = mapper.getAdditions()

    expect:
    list.get(0) == file0
    list.get(1) == file1

    where:
    fileExtentions || file0 | file1
    false          || 'YDN_Addition' | 'YDN_Addition2'
    true           || 'YDN_Addition.png' | 'YDN_Addition2.png'
  }

  def 'getOrphans'() {
    setup:
    IOKoboldMapper mapper = new IOKoboldMapper(new FileInputStream(new File(INPUT)), new FileInputStream(new File(ERROR)), fileExtentions)
    List list = mapper.getOrphans()

    expect:
    list.get(0) == file0
    list.get(1) == file1

    where:
    fileExtentions || file0 | file1
    false          || 'YDN_Orphans' | 'YDN_Orphans2'
    true           || 'YDN_Orphans.png' | 'YDN_Orphans2.png'
  }

  def 'getDifferences'() {
    setup:
    IOKoboldMapper mapper = new IOKoboldMapper(new FileInputStream(new File(INPUT)), new FileInputStream(new File(ERROR)), fileExtentions)
    List list = mapper.getDifferences()

    expect:
    list.get(0) == file0
    list.get(1) == file1

    where:
    fileExtentions || file0 | file1
    false          || 'YDN_Color' | 'YDN_Upper'
    true           || 'YDN_Color.png' | 'YDN_Upper.png'
  }

  def 'getKobold'() {
    setup:
    IOKoboldMapper mapper = new IOKoboldMapper(new FileInputStream(new File(INPUT)), new FileInputStream(new File(ERROR)), fileExtentions)
    Kobold kobold = mapper.getKobold()

    expect:
    kobold.additions.size() == 2
    kobold.orphans.size() == 2
    kobold.differences.size() == 2

    where:
    fileExtentions || _
    false          || _
    true           || _

  }


}
