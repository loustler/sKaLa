package io.github.loustler.kase

/**
  * @author loustler
  * @since 10/20/2018
  */
sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

class ExpressionFormatter {
  private val opGroups: Array[Set[String]] = Array[Set[String]](
    Set("|", "||"),
    Set("&", "&&"),
    Set("^"),
    Set("==", "!="),
    Set("<", "<=", ">", ">="),
    Set("+", "-"),
    Set("*", "%")
  )

  private val precedence = {
    val assocs = for {
      i <- opGroups.indices // It's like 0 until opGroups.size
      op <- opGroups(i)
    } yield op -> i

    assocs.toMap
  }

  private val unaryPrecedence: Int = opGroups.size
  private val fractionPrecedence: Int = -1
}
