package io.github.loustler.collection

import io.github.loustler.BaseTest

/**
  * @author loustler
  * @since 11/02/2018
  */
class ImplLogictest extends BaseTest {
  "ImplLogic" should "be able to partition like TraversableLike" in {
    val x: List[Int]      = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val f: Int => Boolean = a => a < 5

    val (success: List[Int], fail: List[Int]) = ImplLogic.partition(x)(f)

    success should contain allOf (1, 2, 3, 4)
    fail should contain allOf (5, 6, 7, 8, 9)
  }
}
