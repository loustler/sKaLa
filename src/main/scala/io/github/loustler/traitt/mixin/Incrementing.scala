package io.github.loustler.traitt.mixin

/**
  * @author loustler
  * @since 08/25/2018
  */
trait Incrementing extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(x + 1)
}
