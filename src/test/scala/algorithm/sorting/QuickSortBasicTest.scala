package algorithm.sorting

import infrastructure.BaseTableDrivenTest

class QuickSortBasicTest extends BaseTableDrivenTest {

  val table = Table(
    ("Unsorted List",                                    "List"),

    (List(23, 45, 16, 37, 3, 99, 22),                    List(3, 16, 22, 23, 37, 45, 99)),
    (List(3,7,2,8,2,782,7,29,1,3,0,34),                  List(0, 1, 2, 2, 3, 3, 7, 7, 8, 29, 34, 782))
  )

  test("should ") {
    forAll(table)((unSortedList: List[Int], expected: List[Int]) => {
      QuickSortBasic(unSortedList) should equal(expected)
    })
  }
}

