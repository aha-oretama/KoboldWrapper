package aha.oretama.jp.mapper

import aha.oretama.jp.model.Kobold
import spock.lang.Specification

/**
 * @author sekineyasufumi on 2016/11/01.
 */
class IOKoboldMapperTest extends Specification {

  IOKoboldMapper mapper

  def setup() {
    mapper = new IOKoboldMapper(new FileInputStream(new File("src/test/resources/iodata/io.txt")),new FileInputStream(new File("src/test/resources/iodata/error.txt")))
  }

  def 'getAdditions'() {
    setup:
    List list = mapper.getAdditions()

    expect:
    list.get(0) == 'YDN_Addition'
    list.get(1) == 'YDN_Addition2'
  }

  def 'getOrphans'() {
    setup:
    List list = mapper.getOrphans()

    expect:
    list.get(0) == 'YDN_Orphans'
    list.get(1) == 'YDN_Orphans2'
  }

  def 'getDifferences'() {
    setup:
    List list = mapper.getDifferences()

    expect:
    list.get(0) == 'YDN_Color'
    list.get(1) == 'YDN_Upper'
  }

  def 'getKobold'() {
    setup:
    Kobold kobold = mapper.getKobold()

    expect:
    kobold.additions.size() == 2
    kobold.orphans.size() == 2
    kobold.differences.size() == 2

  }

}
