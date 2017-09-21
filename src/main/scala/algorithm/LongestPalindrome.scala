package algorithm

//https://leetcode.com/problems/longest-palindromic-substring/description/
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.

object LongestPalindrome {
  def apply(s: String): String = {
    s.toArray.foldLeft(Result("", "", false))((acc, ele) => {
      acc match {
        case t@Result("", _, false) => t.copy(longestStr = ele.toString)
        case t@Result(longestStr, _, false)
          if longestStr.indexOf(ele) != -1 => t.copy(longestStr = shapeLongestStr(longestStr, ele), done = true)
        case t@Result(longestStr, _, false)
          if longestStr.indexOf(ele) == -1 => t.copy(longestStr = longestStr + ele)
        case t@Result(_, tmpStr, true) if tmpStr.indexOf(ele) != -1 =>
          swapLongestStr(t.copy(tmpStr = shapeLongestStr(tmpStr, ele)))
        case t@Result(_, tmpStr, _) => t.copy(tmpStr = tmpStr + ele)
      }
    }).longestStr
  }

  private def shapeLongestStr(s: String, ele: Char): String = {
    val index = s.indexOf(ele)
    s.substring(index) + ele
  }

  private def swapLongestStr(result: Result): Result = {
    if (result.longestStr.length < result.tmpStr.length) {
      result.copy(longestStr = result.tmpStr, tmpStr = "", done = true)
    } else {
      result.copy(tmpStr = "", done = true)
    }
  }
}

case class Result(longestStr: String, tmpStr: String, done: Boolean)