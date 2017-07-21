package io.github.loustler.abstractInternalControl

/**
  * @author loustler
  * @since 07/21/2017 20:52
  */
object ByNameParameter {
  val assertionEnabled: Boolean = true

  /**
    * This function use closure from field in this object.
    *
    * @param predicate
    * @return
    */
  def myAssert(predicate: () => Boolean) =
    if ( assertionEnabled && !predicate() )
      throw new AssertionError


  def myAssert2(predicate: => Boolean) =
    if (assertionEnabled && !predicate)
      throw new AssertionError


  /**
    * What's difference between [[ByNameParameter.myAssert2()]] and this?
    *
    * If [[ByNameParameter.assertionEnabled]] is false,
    * [[ByNameParameter.myAssert2()]]'s predicate not work.
    * But this function must to work.
    * Cause this function's arguments have side-effects,
    * but [[ByNameParameter.myAssert2()]] haven't.
    *
    * Maybe like this
    * {{{
    *   val x = 10
    *
    *   myAssert2( x / 0 == 0 ) // Its happen nothing.
    *
    *   myAssert3( x / 0 == 0 ) // It is throw ArithmeticException.
    * }}}
    *
    * Therefore [[ByNameParameter.myAssert2()]] is lazy,
    * this function strict.
    *
    * @param predicate
    */
  def myAssert3(predicate: Boolean) =
    if (assertionEnabled && !predicate)
      throw new AssertionError
}
