package algorithm

import dataStructure.tree.UniqueBinarySearchTree
import infrastructure.BaseTableDrivenTest

class UniqueBinarySearchTreeTest extends BaseTableDrivenTest {

  val table = Table(
    ("Value from 1 to",                           "Expected"),

    (1,                                            1),
    (2,                                            2),
    (3,                                            5)
  )

  test("should") {
    forAll(table)((num: Int, expected: Int) => {
      UniqueBinarySearchTree(num) should equal(expected)
    })
  }
}

