package algorithm

object ValidBST {
  def apply(root: TreeNode): Boolean = {

    def isValidBST(tree: Option[TreeNode], min: Int, max: Int): Boolean = {
      tree match {
        case None => true
        case Some(TreeNode(ele, left, right))
          if ele > min && ele < max && isValidBST(left, min, ele) && isValidBST(right, ele, max) =>  true
        case _ => false
      }
    }

    isValidBST(Some(root), Int.MinValue, Int.MaxValue)
  }
}
