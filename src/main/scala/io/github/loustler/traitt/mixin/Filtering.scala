package io.github.loustler.traitt.mixin

/**
  * @author loustler
  * @since 08/25/2018
  */
trait Filtering extends IntQueue {
  abstract override def put(x: Int): Unit = if (x >= 0) super.put(x)
}
