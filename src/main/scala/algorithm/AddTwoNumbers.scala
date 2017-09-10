package algorithm

object AddTwoNumbers {
  def apply(x1: List[Int], x2: List[Int]): List[Int] = {
    var isMoreThan10 = false
    x1.zip(x2).map(t => {
      val result = if (isMoreThan10) {
        isMoreThan10 =false
        t._1 + t._2 + 1
      } else t._1 + t._2

      result match {
        case total if total >= 10 =>
          isMoreThan10 = true
          total - 10
        case total => total
      }
    })
  }
}
