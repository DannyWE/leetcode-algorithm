package recursion

import infrastructure.BaseTableDrivenTest
import recurision.CombinationSum

class CombinationSumTest extends BaseTableDrivenTest {

  val table = Table(
    ("List",                              "Target",                                             "Expected"),

    (List(2, 3, 6, 7),                        7,                                         List(List(2, 2, 3), List(7)))
  )

  test("should ") {
    forAll(table)((list: List[Int],
                   target: Int,
                   expected: List[List[Int]]) => {
      CombinationSum(list, target) should equal(expected)
    })
  }
}

