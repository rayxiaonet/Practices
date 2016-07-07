package net.rayxiao

/**
  * Created by rxiao on 7/7/16.
  */
object MedianOfTwoSortedArray extends App {

  val nums1 = Array(1, 2, 5, 6, 7)
  val nums2 = Array(3, 4, 9, 10)
  val nums3 = Array(3, 4)
  nums3(0) = 4

  def merge(ar1: Array[Int], ar2: Array[Int]): Array[Int] = {
    //i know this is not people want, usually they want O(n), but I just use leet code to learn scala lol
    ar1 ++ ar2.sortWith(_ < _)

  }

  def findMedian(ar: Array[Int]): Int = ar.length match {
    case 1 => return ar(0)
    case 2 => return (ar(0) + ar(1)) / 2
    case _ => findMedian(ar.drop(1).dropRight(1))
  }

  println(findMedian(merge(nums1, nums2)))

}
