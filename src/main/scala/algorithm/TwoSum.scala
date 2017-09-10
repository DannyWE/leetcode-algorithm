package algorithm

object TwoSum {

//  Given nums = [2, 7, 11, 15], target = 9,
//  Because nums[0] + nums[1] = 2 + 7 = 9,
//  return [0, 1].

  def apply(nums: Array[Int], target: Int): Option[List[Int]] = {
    var findIndex: Int = 0
    nums.view.zipWithIndex.collectFirst {
      case t if nums.view.zipWithIndex.exists(ele => {
        findIndex = ele._2
        ele._1 + t._1 == target
      }) => List(t._2, findIndex)
    }
  }
}
