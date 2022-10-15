package com.kulgeiko.scala.algorithms.greedy

import com.kulgeiko.scala.algorithms.Utils._

case class Job(weigth: Int, length: Int, greedyDiff: Option[Int], greedyRatio: Option[Float])

object SchedulingProblem {

  def main(args: Array[String]): Unit = {


    val list = readListNumPairs("/stanford/course3/week1_jobs.txt")
    val jobs = list.map(p => Job(p._1, p._2, Some(p._1 - p._2), Some(p._1.toFloat / p._2)))

    val jobsSortedByDiff = jobs.sortBy(j => (j.greedyDiff.get, j.weigth)).reverse
    val jobsSortedByRatio = jobs.sortBy(j => j.greedyRatio.get).reverse

    println(weightedSum(jobsSortedByDiff))
    println(weightedSum(jobsSortedByRatio))

    def weightedSum(jobs: List[Job]): Long = {
      var acc: Long = 0
      var curLen: Long  = 0

      for (job <- jobs) {
        curLen = curLen + job.length
        acc = acc + curLen * job.weigth
      }
      acc
    }
  }
}

