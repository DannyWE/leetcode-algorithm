package dataStructure.tree

object ValidBST {
  def apply(root: BinaryTree): Boolean = {

    def isValidBST(tree: Option[BinaryTree], min: Int, max: Int): Boolean = {
      tree match {
        case None => true
        case Some(BinaryTree(ele, left, right))
          if ele > min && ele < max && isValidBST(left, min, ele) && isValidBST(right, ele, max) =>  true
        case _ => false
      }
    }

    isValidBST(Some(root), Int.MinValue, Int.MaxValue)
  }
}
