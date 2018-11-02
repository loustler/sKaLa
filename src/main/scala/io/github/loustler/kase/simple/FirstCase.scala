package io.github.loustler.kase.simple

/**
  * @author loustler
  * @since 10/20/2018
  */
abstract class FirstCase
case class Var(name:       String) extends FirstCase
case class Number(value:   Double) extends FirstCase
case class UnOp(operatior: String, arg: FirstCase) extends FirstCase
case class BinOp(operator: String, left: FirstCase, right: FirstCase) extends FirstCase

object SimpleMatcher {
  /*
      -, +, 0, * and 1 are matches by == operator.
   */
  def simplifyTop(x: FirstCase): FirstCase = x match {
    case UnOp("-", UnOp("-", e))  => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("*", e, Number(1)) => e
    case _                        => x
  }
}
