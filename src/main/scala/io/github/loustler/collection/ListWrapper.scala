package io.github.loustler.collection

/**
  * @author loustler
  * @since 10/27/2018
  */
object ListWrapper {
  def prepend[A](list: List[A], x: A): List[A] = x :: list

  def prepend[A](list: List[A], x: A*): List[A] = x.foldLeft(list)((ls, e) => e :: ls)

  def append[A](list: List[A], x: A): List[A] = list :+ x

  def append[A](list: List[A], x: A*): List[A] = merge(list, x.toList)

  def merge[A](x: List[A], y: List[A]): List[A] = x ::: y

  def merge[A](x: List[A]*): List[A] = x.foldLeft(List[A]())(merge)
}
