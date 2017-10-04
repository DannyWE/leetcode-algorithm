package algorithm

import algorithm.basic.ReverseInteger
import infrastructure.BaseTableDrivenTest

class ReverseIntegerTest extends BaseTableDrivenTest {

  val table = Table(
    ("Number",                                            "Expected"),
//    (321,                                                 123),
//    (-321,                                                -123),
    (2147483647,                                          0)
//    (54321,                                               12345)
  )

  test("should ") {
    forAll(table)((number: Int, reversedNumber: Int) => {
      ReverseInteger(number) should equal(reversedNumber)
    })
  }
}

