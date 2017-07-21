package io.github.loustler.abstractInternalControl

import org.scalatest.FunSuite

/**
  * @author loustler
  * @since 07/21/2017 20:54
  */
class ByNameParameterTest extends FunSuite {
  test("The assertion should be true") {
    ByNameParameter myAssert (() => 5 > 3)
    ByNameParameter myAssert2 5 > 3 // It is awesome!
  }
}
