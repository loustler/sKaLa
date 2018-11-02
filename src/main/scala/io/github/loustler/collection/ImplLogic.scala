package io.github.loustler.collection

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
}
