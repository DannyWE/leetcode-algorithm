package algorithm

import algorithm.basic.Atoi
import infrastructure.BaseTableDrivenTest

class AtoiTest extends BaseTableDrivenTest {

  val table = Table(
    ("String",     "Expected"),
    ("   ",           0),
    ("atest",         0),
    ("123",          123)
  )

  test("should ") {
    forAll(table)((str: String, expected: Int) => {
       Atoi(str) should equal(expected)
    })
  }
}

