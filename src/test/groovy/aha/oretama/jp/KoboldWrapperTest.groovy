package aha.oretama.jp

import spock.lang.Specification

class KoboldWrapperTest extends Specification {

  def 'constructor_noArgs'() {
    when:
    KoboldWrapper koboldWrapper = new KoboldWrapper()

    then:
    koboldWrapper.execCommand('test') == 'kobold test'
  }

  def 'constructor_withArgs'() {
    when:
    KoboldWrapper koboldWrapper = new KoboldWrapper("./kobold")

    then:
    koboldWrapper.execCommand('test') == './kobold test'
  }

  def 'approved'() {
    when:
    KoboldWrapper koboldWrapper = new KoboldWrapper().approved("approvedFolder")

    then:
    koboldWrapper.execCommand('test') == 'kobold --approved-folder approvedFolder test'
  }

  def 'build'() {
    when:
    KoboldWrapper koboldWrapper = new KoboldWrapper().build("buildFolder")

    then:
    koboldWrapper.execCommand('test') == 'kobold --build-folder buildFolder test'
  }

  def 'highlight'() {
    when:
    KoboldWrapper koboldWrapper = new KoboldWrapper().highlight("highlightFolder")

    then:
    koboldWrapper.execCommand('test') == 'kobold --highlight-folder highlightFolder test'
  }

  def 'config'() {
    when:
    KoboldWrapper koboldWrapper = new KoboldWrapper().config("configFolder")

    then:
    koboldWrapper.execCommand('test') == 'kobold --config-folder configFolder test'
  }

  def 'failOrphans'() {
    when:
    KoboldWrapper koboldWrapper = new KoboldWrapper().failOrphans()

    then:
    koboldWrapper.execCommand('test') == 'kobold --fail-orphans test'
  }

  def 'failAdditios'() {
    when:
    KoboldWrapper koboldWrapper = new KoboldWrapper().failAdditios()

    then:
    koboldWrapper.execCommand('test') == 'kobold --fail-additions test'
  }
}
