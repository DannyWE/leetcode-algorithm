package algorithm.divideAndConquer

/*
https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 */

object MediumOfTwoSortedArray {
  def apply(list1: Array[Int],
            list1Length: Int,
            list2: Array[Int],
            list2Length: Int): Double = {


    if ((list1Length + list2Length) % 2 == 1 ) {
      findKth(list1, list2, (list1Length + list2Length) / 2, 0, list1Length - 1, 0, list2Length - 1)
    } else {
      (
        findKth(list1, list2, (list1Length + list2Length) / 2, 0, list1Length - 1, 0, list2Length - 1)
        + findKth(list1, list2, (list1Length + list2Length) / 2 -1, 0, list1Length - 1, 0, list2Length - 1)
      ) * 0.5
    }
  }

  private def findKth(listA: Array[Int],
                      listB: Array[Int],
                      k : Int,
                      aStart: Int,
                      aEnd: Int,
                      bStart: Int,
                      bEnd: Int
                     ): Int = {
    val aLength = aEnd - aStart + 1
    val bLength = bEnd - bStart + 1

    if (aLength == 0) {
      return listB(bStart + k)
    }
    if (bLength == 0) {
      return listA(aStart + k)
    }
    if (k == 0) {
      return Math.min(listA(aStart), listB(bStart))
    }

    var aMid = aLength * k / (aLength + bLength)
    var bMid = k - aMid - 1
    aMid = aMid + aStart
    bMid = bMid + bStart

    if (listA(aMid) > listB(bMid)) {
      val newK = k - (bMid - bStart + 1)
      val newAEnd = aMid
      val newBStart = bMid + 1
      findKth(listA, listB, newK, aStart, newAEnd, newBStart, bEnd)
    } else {
      val newK = k - (aMid - aStart + 1)
      val newAStart = aMid + 1
      val newBEnd = bMid
      findKth(listA, listB, newK, newAStart, aEnd, bStart, newBEnd)
    }

  }

}
