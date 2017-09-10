package algorithm

import scala.annotation.tailrec

case class TreeNode(_value: Int,
                    left: Option[TreeNode],
                    right: Option[TreeNode]
                   )

object SameTree {

  def apply(p: TreeNode, q: TreeNode): Boolean = compareTo(p, q)

  def compareTo(p: TreeNode, q: TreeNode): Boolean = {
    (p, q) match {
      case (TreeNode(value1, None, None), TreeNode(value2, None, None)) if value1 == value2 => true
      case (TreeNode(value1, Some(t), None),
      TreeNode(value2, Some(r), None)) if value1 == value2 => compareTo(t, r)
      case (TreeNode(value1, None, Some(t)),
      TreeNode(value2, None, Some(r))) if value1 == value2 => compareTo(t, r)
      case (TreeNode(value1, Some(left1), Some(right1)),
      TreeNode(value2, Some(left2), Some(right2))) if value1 == value2 => compareTo(left1, left2) && compareTo(right1, right2)
      case _ => false
  }
  }
}
