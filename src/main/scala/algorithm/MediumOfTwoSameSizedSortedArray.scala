package algorithm

import infrastructure.ErrorOr

import scala.annotation.tailrec
import scala.util.{Failure, Success, Try}

object MediumOfTwoSameSizedSortedArray {

  def apply(nums1: Array[Int], nums2: Array[Int], size: Int): ErrorOr[Double] = {
    Try {
      findMedian(nums1, nums2, size)
    } match {
      case Success(t) => Right(t)
      case Failure(e) => Left(e)
    }
  }

  @tailrec
  private def findMedian(nums1: Array[Int], nums2: Array[Int], size: Int): Double = {
    if (size == 1) {
      return (nums1(0) + nums2(0)).toDouble / 2
    }
    if (size == 2) {
      return (Math.max(nums1(0), nums2(0)) + Math.min(nums1(1), nums2(1))).toDouble / 2
    }
    val middle = (size.toDouble / 2 + 0.5).toInt
    val middleIndex = size / 2
    if (nums1(middleIndex) >= nums2(middleIndex)) {
      findMedian(nums1.slice(0, middle), nums2.slice(middleIndex, size), middle)
    } else {
      findMedian(nums1.slice(middleIndex, size), nums2.slice(0, middle), middle)
    }
  }

}
