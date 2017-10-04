package algorithm

import dataStructure.hashtable.TwoSum
import infrastructure.BaseTableDrivenTest

class TwoSumTest extends BaseTableDrivenTest {

  val table = Table(
    ("Given Array",                      "Given Target Number",                            "Expected two indices"),

    (Array(2, 7, 11, 15),                9,                                                Some(List(0, 1))),
    (Array(2, 7, 11, 15),                13,                                               Some(List(0, 2))),
    (Array(2, 7, 15, 30),                45,                                               Some(List(2, 3))),
    (Array(2, 7, 15, 30),                100,                                              None)
  )

  test("should be working based on all table cases") {
    forAll(table)((data: Array[Int],
                   target: Int,
                   expected: Option[List[Int]]) => {

      TwoSum(data, target) should equal(expected)
    })
  }
}
