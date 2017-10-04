package algorithm

import algorithm.basic.PalindromeNumber
import infrastructure.BaseTableDrivenTest

class PalindromeNumberTest extends BaseTableDrivenTest {

  val table = Table(
    ("Number",                     "Expected"),
    (123,                           false),
    (151,                           true),
    (3,                             true)
  )

  test("should ") {
    forAll(table)((number: Int, expected: Boolean) => {
      PalindromeNumber(number) should equal(expected)
    })
  }
}

