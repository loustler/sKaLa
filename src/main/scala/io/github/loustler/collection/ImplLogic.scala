package io.github.loustler.collection

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * @author loustler
  * @since 11/02/2018
  */
object ImplLogic {
  def partition[A](x: List[A])(f: A => Boolean): (List[A], List[A]) = {
    val l, r = new ListBuffer[A]()

    for (e <- x) (if (f(e)) l else r) += e

    (l.toList, r.toList)
  }

  def flattenLeft[A](x: List[List[A]]): List[A] =
    (List[A]() /: x)(_ ::: _)

  def flattenRight[A](x: List[List[A]]): List[A] =
    (x :\ List[A]())(_ ::: _)

  def reverseLeft[A](x: List[A]): List[A] =
    (List[A]() /: x)((ls, e) => e :: ls)

  def reverseRight[A](x: List[A]): List[A] =
    (x :\ List[A]())((e, ls) => e :: ls)

  // It seems like toMap in Tuple2
  def toMap[A, B](keys: List[A], values: List[B]): Map[A, B] = {
    val builder: mutable.Builder[(A, B), Map[A, B]] = Map.newBuilder[A, B]

    for (tuple <- keys zip values)
      builder += tuple

    builder.result()
  }
}
