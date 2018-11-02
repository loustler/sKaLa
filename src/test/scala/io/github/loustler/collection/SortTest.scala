package io.github.loustler.collection

import io.github.loustler.BaseTest

/**
  * @author loustler
  * @since 11/02/2018
  */
class SortTest extends BaseTest {

  /**
    * stacktrace is
    * List(1, 5, 6, 2, 0, 7, 9, 3, 4, 8, 13, 12, 15, 17)
    * List(1, 5, 6, 2, 0, 7, 9)
    * List(1, 5, 6)
    * List(1)
    * List(5, 6)
    * List(5)
    * List(6)
    *
    * 5 < 6
    * 5 :: 6
    *
    * 1 < 5
    * 1 :: List(5, 6)
    *
    * List(2, 0, 7, 9)
    * List(2, 0)
    * List(2)
    * List(0)
    *
    * 2 > 0
    * 0 :: 2
    *
    * 7 < 9
    * 7 :: 9
    *
    * 0 < 7
    * 2 < 7
    * 2 :: List(7, 9)
    * 0 :: List(2, 7, 9)
    *
    * List(1, 5, 6) List(0, 2, 7, 9)
    * 0 < 1
    * 1 < 2
    * 2 < 5
    * 5 < 7
    * 6 < 7
    *
    * 6 :: List(7, 9)
    * 5 :: List(6, 7, 9)
    * 2 :: List(5, 6, 7, 9)
    * 1 :: List(2, 5, 6, 7, 9)
    * 0 :: List(1, 2, 5, 6, 7, 9)
    * List(0, 1, 2, 5, 6, 7, 9) // Completed left array sort
    *
    * List(3, 4, 8, 13, 12, 15, 17)
    * List(3, 4, 8)
    * List(3)
    * List(4, 8)
    * List(4)
    * List(8)
    *
    * 4 < 8
    * 4 :: 8
    *
    * 3 < 4
    * 3 :: List(4, 8)
    *
    * List(13, 12, 15, 17)
    * List(13, 12)
    * List(13)
    * List(12)
    *
    * 12 < 13
    * 12 :: 13
    *
    * List(15, 17)
    * List(15)
    * List(17)
    *
    * 15 < 17
    * 15 :: 17
    *
    * List(12, 13) List(15, 17)
    * 12 < 15
    * 13 < 15
    *
    * 13 :: List(15, 17)
    * 12 :: List(13, 15, 17)
    *
    * List(3, 4, 8) List(12, 13, 15, 17)
    *
    * 3 < 12
    * 4 < 12
    * 8 < 12
    * 8 :: List(12, 13, 15, 17)
    * 4 :: List(8, 12, 13, 15, 17)
    * 3 :: List(4, 8, 12, 13, 15, 17)
    *
    * List(0, 1, 2, 5, 6, 7, 9) List(3, 4, 8, 12, 13, 15, 17)
    *
    * 0 < 3
    * 1 < 3
    * 2 < 3
    * 3 < 5
    * 4 < 5
    * 5 < 8
    * 6 < 8
    * 7 < 8
    * 8 < 9
    * 9 < 12
    * 9 :: List(12, 13, 15, 17)
    * 8 :: List(9, 12, 13, 15, 17)
    * 7 :: List(8, 9, 12, 13, 15, 17)
    * 6 :: List(7, 8, 9, 12, 13, 15, 17)
    * 5 :: List(6, 7, 8, 9, 12, 13, 15, 17)
    * 4 :: List(5, 6, 7, 8, 9, 12, 13, 15, 17)
    * 3 :: List(4, 5, 6, 7, 8, 9, 12, 13, 15, 17)
    * 2 :: List(3, 4, 5, 6, 7, 8, 9, 12, 13, 15, 17)
    * 1 :: List(2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 15, 17)
    * 0 :: List(1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 15, 17)
    *
    * // Completed sort
    * List(0, (1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 15, 17)
    */
  "Sort" should "success by merge" in {
    val maxValue:        Int       = 17
    val minValue:        Int       = 0
    val unsortedNumbers: List[Int] = List(1, 5, 6, 2, minValue, 7, 9, 3, 4, 8, 13, 12, 15, maxValue)

    val compare: (Int, Int) => Boolean = (a: Int, b: Int) => a < b

    val sortedList: List[Int] = Sort.merge(compare)(unsortedNumbers)

    sortedList.head shouldBe minValue
    sortedList.last shouldBe maxValue
  }
}
