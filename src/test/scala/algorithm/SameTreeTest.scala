package algorithm

import infrastructure.BaseTableDrivenTest

class SameTreeTest extends BaseTableDrivenTest {

  val table = Table(
    ("Tree",                                               "Tree to Compare",                                             "Expected Result"),

    (TreeNode(3, None, None),                              TreeNode(3, None, None),                                        true),
    (TreeNode(3, None, None),                              TreeNode(4, None, None),                                        false),
    (TreeNode(3, None, None),                              TreeNode(4, Some(TreeNode(3, None, None)), None),               false),
    (TreeNode(3, Some(TreeNode(3, None, None)), None),     TreeNode(3, Some(TreeNode(3, None, None)), None),               true),
    (TreeNode(3, Some(TreeNode(3, None, None)),
      Some(TreeNode(3, None, None))),                      TreeNode(3, Some(TreeNode(3, None, None)), None),               false),
    (TreeNode(3, Some(TreeNode(3, None, None)),
      Some(TreeNode(3, None, None))),                      TreeNode(3, Some(TreeNode(3, None, None)),
                                                           Some(TreeNode(7, None, None))),                                 false),
    (TreeNode(3, Some(TreeNode(3, None, None)),
      Some(TreeNode(3, None, None))),                      TreeNode(3, Some(TreeNode(3, None, None)),
                                                           Some(TreeNode(3, None, None))),                                 true),
  )

  test("should ") {
    forAll(table)((treeNode: TreeNode,
                   treeNodeToComapre: TreeNode,
                   expectedResult: Boolean
                  ) => {
          SameTree(treeNode, treeNodeToComapre) should equal(expectedResult)
    })
  }
}
