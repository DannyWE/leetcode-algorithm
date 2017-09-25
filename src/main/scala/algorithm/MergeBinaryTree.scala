package algorithm

object MergeBinaryTree {

  def apply(tree1: BinaryTree, tree2: BinaryTree): BinaryTree = {
    if (tree1 == null) return tree2
    if (tree2 == null) return tree1

    mergeTree(Some(tree1), Some(tree2)).orNull
  }

  def mergeTree(tree1: Option[BinaryTree], tree2: Option[BinaryTree]): Option[BinaryTree] = {
    (tree1, tree2) match {
      case (Some(t1), Some(t2)) => Some(
        BinaryTree(t1._value + t2._value, mergeTree(t1.left, t2.left), mergeTree(t1.right, t2.right))
      )
      case (None, t) => t
      case (t, None) => t
    }
  }
}
