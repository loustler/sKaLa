package io.github.loustler.traitt

/**
  * @author loustler
  * @since 08/25/2018
  */
abstract class Component extends Rectangular {
  def topLeft: Point
  def bottomLeft: Point
}
