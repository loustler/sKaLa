package io.github.loustler.buildInControlStructure

import scala.annotation.tailrec
import scala.collection.IndexedSeqOptimized

/**
  * @author loustler
  * @since 07/21/2017 21:18
  */
object BuildInExample {
  val argz = Array[String]("the first example", "for build-in on scala")

  val fileName =
    if (!argz.isEmpty) argz(0)
    else "default"

  private val languages = Array("scala",
                                "java",
                                "ruby",
                                "python",
                                "javascript",
                                "SQL",
                                "go",
                                "swift",
                                "c")

  def printByTo: Unit = {
    // Loop range use for syntax
    for (i <- 1 to 4)
      println(i)
  }

  def printByUntil: Unit = {
    // Loop range which exclude max value use for syntax
    for (i <- 1 until 4)
      println(i)
  }

  def printOneOfTheTopInDivisionResult(x: Long, y: Long): Unit = {
    printf("%d, %d Greatest Common Divisor is %d", x, y, gcdLoop(x, y))
  }

  // Functional Programming don't recommend to use loop like below
  def gcdLoop(x: Long, y: Long): Long = {
    var a = x

    var b = y

    while (a != 0) {
      val temp = a

      a = b % a

      b = temp
    }

    b
  }

  def notRecommendedInScala(l: Array[Int]): Unit = {
    // Not use like in scala
    for (i <- 0 to l.length - 1)
      println(l(i))
  }

  def filterInFor(l: Array[Int], p: => Boolean): Unit = {
    // Filter case 1
    for (i <- l if p)
      println(i)
  }

  def filterInFor2(l: Array[Int], p: => Boolean): Unit = {
    // Filter case 2
    for (i <- l)
      if (p)
        println(i)
  }

  def filterInFor3(l: Array[Int], p: => Boolean, p2: => Boolean): Unit = {
    // Filter case 3
    for (i <- l
         if p
         if p2)
      println(i)
  }

  // Functional Programming recommend to want use loop like below
  @tailrec
  def gcd(x: Long, y: Long): Long =
    if (y == 0) x else gcd(y, x % y)

  def filterTwiceList(l: Array[Int],
                      p: => Boolean,
                      l2: Array[String],
                      p2: => Boolean): Unit = {
    for (i <- l
         if p;
         j <- l2
         if p2)
      printf("The number is %d, The string is %s\n", i, j)
  }

  def forMapAndFilter(l: Array[String], p: => Boolean, m: => String): Unit = {
    // Binding value in for loop
    for {
      s <- l
      if p
      mappedS <- m
    } printf("%s mapped %s\n", s, mappedS)
  }

  def yieldResult(l: Array[String], p: => Boolean): Array[String] = {
    // Create new collection in for loop
    for {
      s <- l
      if p
    } yield s
  }

  // A <: B => A is subclass of B
  // A >: B => A is superclass of B
  def foreachPrintln[A](l: Array[A]): Unit = {
    l.foreach(println)
  }
}
