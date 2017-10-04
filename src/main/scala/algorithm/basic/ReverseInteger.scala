package algorithm.basic

/*
https://leetcode.com/problems/reverse-integer/description/
 */

import scala.util.{Success, Try}

object ReverseInteger {
  def apply(number: Int): Int = {
    val exactNumber = Math.abs(number)
    val charArray = exactNumber.toString.toCharArray
    val length = charArray.length
    val half = (length + 1) / 2
    var last = length - 1

    Try {
       (0 until half).foldLeft(exactNumber.toString)((acc, i) => {
        val result = reverseStr(acc, i, last)
        last = last - 1
        result
      }).toInt
    } match {
      case Success(reversedNumber) =>
        if (number < 0) {
          Math.negateExact(reversedNumber)
        } else {
          reversedNumber
        }
      case _ => 0
    }
  }

  def reverseStr(s: String, start: Int, end: Int): String = {
    if (start >= end) {
      return s
    }
    val sStart = s(start)
    val sEnd = s(end)
    s.substring(0, start) + sEnd + s.substring(start + 1, end) + sStart + s.substring(end + 1)
  }
}
