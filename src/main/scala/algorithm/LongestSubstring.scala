package algorithm

//Longest Substring Without Repeating Characters
//REF: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
//Given "abcabcbb", the answer is "abc", which the length is 3.
//Given "bbbbb", the answer is "b", with the length of 1.
//Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

object LongestSubstring {
  def apply(s: String): Int = {
    s.toArray.foldLeft(List("", ""))((acc, ele) => {
      acc match {
        case head :: "" :: Nil if head.indexOf(ele) == -1 => List(head + ele, "")
        case head :: "" :: Nil => List(head, ele.toString)
        case head :: last :: Nil if last.indexOf(ele) == -1 => List(head, last + ele)
        case head :: last :: Nil if last.indexOf(ele) == 1 && last.length > head.length => List(last, "")
        case head :: last :: Nil if last.indexOf(ele) == 1 && last.length <= head.length => List(head, "")
        case _ => acc
      }
    }).map(_.length).max
  }

}
