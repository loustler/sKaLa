package io.github.loustler.traitt.mixin

import scala.collection.mutable.ArrayBuffer

/**
  * @author loustler
  * @since 08/25/2018
  */
class BasicIntQueue extends IntQueue {
  private[this] val buf: ArrayBuffer[Int] = ArrayBuffer[Int]()

  override def get(): Int = buf.remove(0)

  override def put(x: Int): Unit = buf += x

  override def size: Int = buf.size
}
