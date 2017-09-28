package algorithm.sorting

import scala.collection.mutable.ListBuffer

object QuickSortBasic {

  def apply(list: List[Int]): List[Int] = {
    sort(list)
  }

  def sort(list: List[Int]): List[Int] = {
    list match {
      case Nil => Nil
      case head :: Nil => list
      case head :: tail =>
        val leftBuffer = ListBuffer[Int]()
        val rightBuffer = ListBuffer[Int]()
        val pivot: Int = head

        for (ele <- tail) {
          if (ele < pivot) {
            leftBuffer += ele
          } else {
            rightBuffer += ele
          }
        }
        (sort(leftBuffer.toList) :+ pivot) ::: sort(rightBuffer.toList)
    }

  }
}
