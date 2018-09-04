package io.github.loustler.traitt

/**
  * @author loustler
  * @since 08/25/2018
  */
class Rational(val n: Int, val d: Int) extends Ordered[Rational] {
//  def <(that: Rational): Boolean = this.n * this.d < that.n * that.d
//  def >(that: Rational): Boolean = that < this
//  def <=(that: Rational): Boolean = (this < that) || (this == that)
//  def >=(that: Rational): Boolean = (this > that) || (this == that)

  override def compare(that: Rational): Int =
    (this.n * this.d) - (that.n * that.d)
}
