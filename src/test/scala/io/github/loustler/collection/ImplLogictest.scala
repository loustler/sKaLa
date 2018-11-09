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

  it should "be able to return flatten list start from left" in {
    val list1: List[Int]       = 1 to 5 toList
    val list2: List[Int]       = 6 to 10 toList
    val list3: List[Int]       = 11 to 15 toList
    val list4: List[Int]       = 16 to 20 toList
    val x:     List[List[Int]] = List(list1, list2, list3, list4)

    val expectedList: List[Int] = 1 to 20 toList

    val result: List[Int] = ImplLogic.flattenLeft(x)

    result should not be empty
    result should contain allElementsOf expectedList
  }

  it should "be able to return flatten list start from right" in {
    val list1: List[Int]       = 1 to 5 toList
    val list2: List[Int]       = 6 to 10 toList
    val list3: List[Int]       = 11 to 15 toList
    val list4: List[Int]       = 16 to 20 toList
    val x:     List[List[Int]] = List(list1, list2, list3, list4)

    val expectedList: List[Int] = 1 to 20 toList

    val result: List[Int] = ImplLogic.flattenRight(x)

    result should not be empty
    result should contain allElementsOf expectedList
  }

  it should "be able to reverse a list start from left" in {
    val x:            List[Char] = "Hello World!".toCharArray.toList
    val expectedList: List[Char] = List('!', 'd', 'l', 'r', 'o', 'W', ' ', 'o', 'l', 'l', 'e', 'H')

    val result: List[Char] = ImplLogic.reverseLeft(x)

    result should not be empty
    result should contain allElementsOf expectedList
  }

  it should "be able to reverse a list start from right" in {
    val x:            List[Char] = "Hello World!".toCharArray.toList
    val expectedList: List[Char] = List('!', 'd', 'l', 'r', 'o', 'W', ' ', 'o', 'l', 'l', 'e', 'H')

    val result: List[Char] = ImplLogic.reverseRight(x)

    result should not be empty
    result should contain allElementsOf expectedList
  }

  it should "be able to create map from two list" in {
    val keys:   List[String] = List("CP", "LeBRON", "KD", "Kyrie")
    val values: List[Int]    = List(3, 23, 35, 11)

    val nba: Map[String, Int] = ImplLogic.toMap(keys, values)

    nba should not be empty
    nba should have size 4
  }
}
