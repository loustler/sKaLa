package io.github.loustler.traitt.mixin

/**
  * @author loustler
  * @since 09/04/2018
  */
trait DecrementIntQueue extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(x - 1)
}
