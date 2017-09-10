package algorithm

import infrastructure.BaseTableDrivenTest

class SameTreeTest extends BaseTableDrivenTest {

  val table = Table(
    ("Tree",                      "Tree to Compare",                    "Expected Result"),

    (TreeNode(3, None, None),     TreeNode(3, None, None),               true)
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
