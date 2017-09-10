package algorithm

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

//Given two binary trees, write a function to check if they are equal or not.
//Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

object SameTree {

  def apply(p: TreeNode, q: TreeNode): Boolean = Await.result(compareTo(p, q), Duration.Inf)


  def compareTo(p: TreeNode, q: TreeNode): Future[Boolean] = {
    (p, q) match {
      case (TreeNode(value1, None, None), TreeNode(value2, None, None)) if value1 == value2 => Future.successful(true)
      case (TreeNode(value1, Some(t), None),
      TreeNode(value2, Some(r), None)) if value1 == value2 => compareTo(t, r)
      case (TreeNode(value1, None, Some(t)),
      TreeNode(value2, None, Some(r))) if value1 == value2 => compareTo(t, r)
      case (TreeNode(value1, Some(left1), Some(right1)),
      TreeNode(value2, Some(left2), Some(right2))) if value1 == value2 => {
        for {
          result1 <- compareTo(left1, left2)
          result2 <- compareTo(right1, right2)
        } yield result1 && result2
      }
      case _ => Future.successful(false)
  }
  }
}
