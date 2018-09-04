package io.github.loustler.traitt.mixin

/**
  * @author loustler
  * @since 09/04/2018
  */
trait Queue[T] {
  def get(): T
  def put(x: T): Unit
  def size: Int
}
