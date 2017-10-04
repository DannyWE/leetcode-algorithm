package algorithm.basic

//https://leetcode.com/problems/palindrome-number/description/

object PalindromeNumber {

  def apply(x: Int): Boolean = {
    val strX = x.toString
    val length = strX.length
    val half = length / 2
    val last = length - 1

    (0 to half).forall(i => strX(i).equals(strX(last - i)))
  }
}
