package algorithm

import infrastructure.BaseTableDrivenTest

class MergeBinaryTreeTest extends BaseTableDrivenTest {

  val table = Table(
    ("Tree 1",                        "Tree 2",                                  "Expected"),

    (BinaryTree(1,
      Some(BinaryTree(3,
        Some(BinaryTree(5,
          None,
          None)),
        None)),
      Some(BinaryTree(2,
        None,
        None))),                      BinaryTree(2,
                                          Some(BinaryTree(1,
                                            None,
                                            Some(BinaryTree(4,
                                              None,
                                              None)))),
                                          Some(BinaryTree(3,
                                            None,
                                            Some(BinaryTree(7,
                                              None,
                                              None))))),                         BinaryTree(3,
                                                                                  Some(BinaryTree(4,
                                                                                    Some(BinaryTree(5,
                                                                                      None,
                                                                                      None)),
                                                                                    Some(BinaryTree(4,
                                                                                      None,
                                                                                      None)))),
                                                                                  Some(BinaryTree(5,
                                                                                    None,
                                                                                    Some(BinaryTree(7,
                                                                                      None,
                                                                                      None))))))
  )

  test("should merge two binary tree") {
    forAll(table)((tree1: BinaryTree, tree2: BinaryTree, expected: BinaryTree) => {
      MergeBinaryTree(tree1, tree2) should equal(expected)
    })
  }
}

