package algorithm

import infrastructure.BaseTableDrivenTest

class TwoSumTest extends BaseTableDrivenTest {

  val table = Table(
    ("Given Array",                      "Given Target Number",                            "Expected two indices"),

    (Array(2, 7, 11, 15),                9,                                                Some(List(0, 1)))
  )

  test("should be working based on all table cases") {
    forAll(table)((data: Array[Int],
                   target: Int,
                   expected: Option[List[Int]]) => {

      TwoSum(data, target) should equal(expected)
    })
  }
}
