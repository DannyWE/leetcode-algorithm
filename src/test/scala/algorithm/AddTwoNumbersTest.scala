package algorithm

import algorithm.linkedList.AddTwoNumbers
import infrastructure.BaseTableDrivenTest

class AddTwoNumbersTest extends BaseTableDrivenTest {

  val table = Table(
    ("List1",       "List2",             "Expected List"),

    (List(2, 4, 3), List(5, 6, 4),       List(7, 0, 8)),
    (List(2, 4, 3), List(5, 6, 6),       List(7, 0, 0))
  )

  test("should get add two lists together") {
    forAll(table)((list1: List[Int],
                   list2: List[Int],
                   expectedList: List[Int]
                  ) => {
      AddTwoNumbers(list1, list2) should equal(expectedList)
    })
  }
}

