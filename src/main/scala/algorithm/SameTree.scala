package algorithm

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

//Given two binary trees, write a function to check if they are equal or not.
//Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

object SameTree {

  def apply(p: BinaryTree, q: BinaryTree): Boolean = Await.result(compareTo(p, q), Duration.Inf)


  def compareTo(p: BinaryTree, q: BinaryTree): Future[Boolean] = {
    (p, q) match {
      case (BinaryTree(value1, None, None), BinaryTree(value2, None, None)) if value1 == value2 => Future.successful(true)
      case (BinaryTree(value1, Some(t), None),
      BinaryTree(value2, Some(r), None)) if value1 == value2 => compareTo(t, r)
      case (BinaryTree(value1, None, Some(t)),
      BinaryTree(value2, None, Some(r))) if value1 == value2 => compareTo(t, r)
      case (BinaryTree(value1, Some(left1), Some(right1)),
      BinaryTree(value2, Some(left2), Some(right2))) if value1 == value2 => {
        for {
          result1 <- compareTo(left1, left2)
          result2 <- compareTo(right1, right2)
        } yield result1 && result2
      }
      case _ => Future.successful(false)
  }
  }
}
