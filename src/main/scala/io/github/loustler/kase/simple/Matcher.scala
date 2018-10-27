package io.github.loustler.kase.simple

/**
  * @author loustler
  * @since 10/20/2018
  */
object Matcher {
  def deeplySize(x: List[_]): Int = x match {
    case Nil                           => 0
    case List(a: List[_], b: List[_])  => x.size + a.size + b.size
    case List(a: List[_], _ *: AnyRef) => x.size + a.size
    case List(_*)                      => x.size
  }

  def shallowSize(x: List[_]): Int = x match {
    case Nil     => 0
    case List(_) => x.size
    case _       => -1
  }
}
