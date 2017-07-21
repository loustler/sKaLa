package io.github.loustler.abstractInternalControl

import org.scalatest.FunSuite

/**
  * @author loustler
  * @since 07/21/2017 21:03
  */
class ClientSimpleCodeTest extends FunSuite {
  test("The list should be contain number that greater than 0") {
    val list = List(-5, -1, -2, -3, -13, 1)

    assert(ClientSimpleCode.containsNeg(list))
  }

  test("The list2 should be contain number that greater than 0 ") {
    val list2 = List(-5, -1, -2, -3, -13, 1)

    assert(ClientSimpleCode.containsNeg2(list2)) // It was same upper test codes.
  }

  test("The list should be contain odd number") {
    val haveOddList = List(2, 4, 6, 1, 8, 10)

    assert(ClientSimpleCode.containsOdd(haveOddList))
  }

  test("The list2 should be contain odd number") {
    val haveOddList = List(2, 4, 6, 1, 8, 10)

    assert(ClientSimpleCode.containsOdd2(haveOddList))
  }
}
