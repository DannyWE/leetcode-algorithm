package algorithm

//https://leetcode.com/problems/zigzag-conversion/description/

//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//"PAHNAPLSIIGYIR"

object ZigZagConversion {
  def apply(s: String, row: Int): String = {
    var rowInterval = row + row - 2
    (0 to (rowInterval + 1) / 2).foldLeft("")((acc, ele) => {
      val result = acc + getStr(s, ele, rowInterval)
      rowInterval = rowInterval - 2
      if (rowInterval == 0 ) {
        rowInterval = row + row - 2
      }
      result
    })
  }

  def getStr(s: String, start: Int, interval: Int): String = {
    var next = start + interval
    var result: String = s"${s(start)}"
    while(s.indices.contains(next)) {
      result += s(next)
      next += interval
    }
    result
  }
}
