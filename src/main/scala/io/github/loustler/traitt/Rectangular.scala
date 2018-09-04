package io.github.loustler.traitt

/**
  * @author loustler
  * @since 08/25/2018
  */
trait Rectangular {
  def topLeft: Point
  def bottomRight: Point

  def left: Int = topLeft.x
  def right: Int = bottomRight.x
  def width: Int = right - left
}
