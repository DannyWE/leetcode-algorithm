package algorithm

import algorithm.divideAndConquer.MediumOfTwoSameSizedSortedArray
import infrastructure.{BaseTableDrivenTest, ErrorOr}

class MediumOfTwoSameSizedSortedArrayTest extends BaseTableDrivenTest {

  val table = Table(
    ("List 1",                        "List 2",                      "Size",          "Expected"),

    (Array(1, 10, 15,30),             Array(2, 7, 9, 11),            4,              Right(9.5)),
    (Array(1, 12, 15, 26, 38),        Array(2, 13, 17, 30, 45),      5,              Right(16.0)),
    (Array(1, 3, 5, 11, 17),          Array(9, 10, 11, 13, 14),      5,              Right(10.5))
  )

  test("should get medium number") {
    forAll(table)((list1: Array[Int], list2: Array[Int], size: Int, expected: ErrorOr[Double]) => {
      MediumOfTwoSameSizedSortedArray(list1, list2, size) should equal(expected)
    })
  }
}

