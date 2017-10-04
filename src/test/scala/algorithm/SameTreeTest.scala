package algorithm

import dataStructure.tree.{BinaryTree, SameTree}
import infrastructure.BaseTableDrivenTest

class SameTreeTest extends BaseTableDrivenTest {

  val table = Table(
    ("Tree",                                               "Tree to Compare",                                             "Expected Result"),

    (BinaryTree(3, None, None),                              BinaryTree(3, None, None),                                        true),
    (BinaryTree(3, None, None),                              BinaryTree(4, None, None),                                        false),
    (BinaryTree(3, None, None),                              BinaryTree(4, Some(BinaryTree(3, None, None)), None),               false),
    (BinaryTree(3, Some(BinaryTree(3, None, None)), None),     BinaryTree(3, Some(BinaryTree(3, None, None)), None),               true),
    (BinaryTree(3, Some(BinaryTree(3, None, None)),
      Some(BinaryTree(3, None, None))),                      BinaryTree(3, Some(BinaryTree(3, None, None)), None),               false),
    (BinaryTree(3, Some(BinaryTree(3, None, None)),
      Some(BinaryTree(3, None, None))),                      BinaryTree(3, Some(BinaryTree(3, None, None)),
                                                           Some(BinaryTree(7, None, None))),                                 false),
    (BinaryTree(3, Some(BinaryTree(3, None, None)),
      Some(BinaryTree(3, None, None))),                      BinaryTree(3, Some(BinaryTree(3, None, None)),
                                                           Some(BinaryTree(3, None, None))),                                 true),
  )

  test("should validate the same tree ") {
    forAll(table)((treeNode: BinaryTree,
                   treeNodeToComapre: BinaryTree,
                   expectedResult: Boolean
                  ) => {
          SameTree(treeNode, treeNodeToComapre) should equal(expectedResult)
    })
  }
}
