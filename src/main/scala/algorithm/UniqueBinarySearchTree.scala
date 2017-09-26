package algorithm

object UniqueBinarySearchTree {
  def apply(n: Int): Int = {
    val count = Array.fill(n + 1)(0)

    count(0) = 1
    count(1) = 1

    for ( i <- 2 to n) {
      for (j <- 0 until i) {
        count(i) = count(i) + count(j) * count(i - j - 1)
      }
    }
    count(n)
  }
}
