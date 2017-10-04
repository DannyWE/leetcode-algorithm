package algorithm

import dataStructure.tree.{BinaryTree, ValidBST}
import infrastructure.BaseTableDrivenTest

class ValidBSTTest extends BaseTableDrivenTest {

  val table = Table(
     ("Tree",                                                                                          "Expected"),

    (BinaryTree(3, Some(BinaryTree(1, None, None)), Some(BinaryTree(7,  None, None))),                       true),
    (BinaryTree(3, Some(BinaryTree(4, None, None)), Some(BinaryTree(7,  None, None))),                       false),
    (BinaryTree(3, Some(BinaryTree(2, Some(BinaryTree(1, None, None)), None)),
      Some(BinaryTree(7,  None, None))),                                                                 true),
    (BinaryTree(3, Some(BinaryTree(2, Some(BinaryTree(1, None, None)), Some(BinaryTree(4, None, None)))),
      Some(BinaryTree(7,  None, None))),                                                                 false),
    (BinaryTree(4, Some(BinaryTree(3, Some(BinaryTree(2, None, Some(BinaryTree(5, None, None))))
      , Some(BinaryTree(3, None, None)))),
      Some(BinaryTree(7,  None, None))),                                                                 false),
    (BinaryTree(6,
      Some(BinaryTree(4,
        Some(BinaryTree(2,
          Some(BinaryTree(1, None, None)),
          Some(BinaryTree(3, None, None)))),
        Some(BinaryTree(5, None, None)))),
      Some(BinaryTree(7,  None, None))),                                                                 true),
    (BinaryTree(5,
      Some(BinaryTree(3,
        Some(BinaryTree(2, None, None)),
        Some(BinaryTree(4, None, None)))),
      Some(BinaryTree(7,  None, None))),                                                                 true),
    (BinaryTree(5,
      Some(BinaryTree(3,
        Some(BinaryTree(2, None, None)),
        Some(BinaryTree(7, None, None)))),
      Some(BinaryTree(7,  None, None))),                                                                 false),
    (BinaryTree(10,
      Some(BinaryTree(5,
        Some(BinaryTree(2, None, None)),
        Some(BinaryTree(7,
          Some(BinaryTree(6, None, None)),
          Some(BinaryTree(11, None, None)))))),
      Some(BinaryTree(15,  None, None))),                                                                 false)
  )

  test("should valid binary search tree") {
    forAll(table)((root: BinaryTree, expected: Boolean) => {
      ValidBST(root) should equal(expected)
    })
  }
}
