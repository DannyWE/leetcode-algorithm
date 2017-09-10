package algorithm

import infrastructure.BaseTableDrivenTest

class ValidBSTTest extends BaseTableDrivenTest {

  val table = Table(
     ("Tree",                                                                                          "Expected"),

    (TreeNode(3, Some(TreeNode(1, None, None)), Some(TreeNode(7,  None, None))),                       true),
    (TreeNode(3, Some(TreeNode(4, None, None)), Some(TreeNode(7,  None, None))),                       false),
    (TreeNode(3, Some(TreeNode(2, Some(TreeNode(1, None, None)), None)),
      Some(TreeNode(7,  None, None))),                                                                 true),
    (TreeNode(3, Some(TreeNode(2, Some(TreeNode(1, None, None)), Some(TreeNode(4, None, None)))),
      Some(TreeNode(7,  None, None))),                                                                 false),
    (TreeNode(4, Some(TreeNode(3, Some(TreeNode(2, None, Some(TreeNode(5, None, None))))
      , Some(TreeNode(3, None, None)))),
      Some(TreeNode(7,  None, None))),                                                                 false),
    (TreeNode(6,
      Some(TreeNode(4,
        Some(TreeNode(2,
          Some(TreeNode(1, None, None)),
          Some(TreeNode(3, None, None)))),
        Some(TreeNode(5, None, None)))),
      Some(TreeNode(7,  None, None))),                                                                 true),
    (TreeNode(5,
      Some(TreeNode(3,
        Some(TreeNode(2, None, None)),
        Some(TreeNode(4, None, None)))),
      Some(TreeNode(7,  None, None))),                                                                 true),
    (TreeNode(5,
      Some(TreeNode(3,
        Some(TreeNode(2, None, None)),
        Some(TreeNode(7, None, None)))),
      Some(TreeNode(7,  None, None))),                                                                 false),
    (TreeNode(10,
      Some(TreeNode(5,
        Some(TreeNode(2, None, None)),
        Some(TreeNode(7,
          Some(TreeNode(6, None, None)),
          Some(TreeNode(11, None, None)))))),
      Some(TreeNode(15,  None, None))),                                                                 false)
  )

  test("should valid binary search tree") {
    forAll(table)((root: TreeNode, expected: Boolean) => {
      ValidBST(root) should equal(expected)
    })
  }
}
