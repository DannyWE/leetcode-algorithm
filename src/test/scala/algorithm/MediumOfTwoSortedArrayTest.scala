package algorithm

import infrastructure.BaseTableDrivenTest

class MediumOfTwoSortedArrayTest extends BaseTableDrivenTest {

  val table = Table(
    ("List 1",                   "list 1 length",      "List 2",             "list 2 length",           "Expected"),

    (Array(1, 10, 15,30),          4,    Array(2, 7, 9, 11),                    4,                         9.5),
    (Array(1, 12, 15, 26, 38),     5,    Array(2, 13, 17, 30, 45),              5,                         16.0),
    (Array(1, 3, 5, 11, 17),       5,    Array(9, 10, 11, 13, 14),              5,                         10.5),
    (Array(1, 3, 5, 11, 17),       5,    Array(9, 10),                          2,                         9.0),
    (Array(2, 3, 4),               3,    Array(1, 5, 6, 7, 8, 9),               6,                         5.0),
    (Array(1, 5, 6, 7, 8, 9),      6,    Array(2, 3, 4),                        3,                         5.0)
  )

  test("should get medium number") {
    forAll(table)((list1: Array[Int], list1Length: Int, list2: Array[Int], list2Length: Int, expected: Double) => {
      MediumOfTwoSortedArray(list1, list1Length, list2, list2Length) should equal(expected)
    })
  }

}
