package algorithm

import infrastructure.BaseTableDrivenTest

class ZigZagConversionTest extends BaseTableDrivenTest {

  val table = Table(
     ("String",   "row",    "expected")
  )

  test("should zig zag test") {
    forAll(table)((s: String, row: Int, expected: String) => {
             ???
    })
  }
}

