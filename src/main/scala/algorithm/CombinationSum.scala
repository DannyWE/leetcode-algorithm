package algorithm

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

//Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//https://leetcode.com/problems/combination-sum/description/
//For example, given candidate set [2, 3, 6, 7] and target 7
//Result : [7], [2, 2, 3]


object CombinationSum {
  def apply(candidates: List[Int],
            target: Int): List[List[Int]] = {

    val sortedList = candidates.sorted
    val listBuffer: ListBuffer[List[Int]] = ListBuffer()
    findMatched(sortedList, target, 0, List.empty, listBuffer)

    listBuffer.toList
  }

  def findMatched(sortedList: List[Int], target: Int, j: Int, acc: List[Int], listBuffer: ListBuffer[List[Int]]): Unit = {
    if (target == 0) {
      listBuffer += acc
      return
    }

    for (i <- j until sortedList.length) {
      if (sortedList(i) > target) {
        return
      }
      findMatched(sortedList, target - sortedList(i), i,  acc :+ sortedList(i), listBuffer)
    }
  }
}
