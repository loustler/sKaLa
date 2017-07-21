package io.github.loustler.abstractInternalControl

/**
  * @author loustler
  * @since 07/21/2017 21:03
  */
object ClientSimpleCode {
  def containsNeg(nums: List[Int]): Boolean = {
    for (num <- nums)
      if (num < 0)
        return true

    false
  }

  def containsNeg2(nums: List[Int]) = nums.exists(_ < 0)

  def containsOdd(nums: List[Int]): Boolean = {
    for (num <- nums)
      if (num % 2 == 1)
        return true

    false
  }

  def containsOdd2(nums: List[Int]) = nums.exists(_ % 2 == 1)
}
