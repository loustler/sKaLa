package io.github.loustler.traitt.mixin

/**
  * @author loustler
  * @since 08/25/2018
  */
abstract class IntQueue extends Queue[Int] {
  def get(): Int
  def put(x: Int): Unit
}
