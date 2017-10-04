package algorithm

import algorithm.basic.ZigZagConversion
import infrastructure.BaseTableDrivenTest

class ZigZagConversionTest extends BaseTableDrivenTest {

  val table = Table(
    ("String",                                     "row",                         "expected"),
    ("PAYPALISHIRING",                              3,                            "PAHNAPLSIIGYIR")
  )

  test("should zig zag test") {
    forAll(table)((s: String, row: Int, expected: String) => {
      ZigZagConversion(s, row) should equal(expected)
    })
  }
}

