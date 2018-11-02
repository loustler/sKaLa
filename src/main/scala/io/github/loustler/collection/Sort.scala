package io.github.loustler.collection

/**
  * @author loustler
  * @since 11/02/2018
  */
object Sort {
  def merge[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
    def merge1(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, _)             => ys
      case (_, Nil)             => xs
      case (x :: xsl, y :: ysl) => if (less(x, y)) x :: merge1(xsl, ys) else y :: merge1(xs, ysl)
    }

    val n: Int = xs.length / 2
    if (n == 0) xs
    else {
      val (xz: List[T], yz: List[T]) = xs splitAt n
      merge1(merge(less)(xz), merge(less)(yz))
    }
  }
}
