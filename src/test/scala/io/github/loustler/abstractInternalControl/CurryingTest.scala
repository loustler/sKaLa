package io.github.loustler.abstractInternalControl

import org.scalatest.FunSuite

/**
  * @author loustler
  * @since 07/21/2017 20:57
  */
class CurryingTest extends FunSuite {
  test("The curried function should be success") {
    val fun = (x: Int, y: Int) => x + y

    val curriedFunction = Currying currying (5, fun)

    assert(curriedFunction(5) == 10)
  }

  test("The another curried function should be success") {
    val curriedFunction = Currying.curriedSum(5)(_)

    assert(curriedFunction(5) == 10)
  }

  test("The 3rd curreid function should be success") {
    val curriedFunction = Currying first (5)

    assert(curriedFunction(5) == 10)
  }
}
