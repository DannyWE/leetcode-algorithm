package algorithm

object LongestCommonPrefix {
  def apply(strList: List[String]): String = {
    findCommonPrefix(strList, 0, "")
  }

  def findCommonPrefix(strList: List[String],
                       index: Int,
                       acc: String): String = {
    var temp: Option[Char] = None
    strList.foreach(t => {
      if (!t.indices.contains(index) || (temp.isDefined && temp.exists(_ != t.charAt(index)))) {
        return acc
      } else {
        temp = Some(t.charAt(index))
      }
    })
    findCommonPrefix(strList, index + 1, acc + temp.getOrElse(""))
  }
}
