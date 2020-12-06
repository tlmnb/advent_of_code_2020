package io.dolcefarniente.advent_of_code

import scala.io.Source

object DaySix {

  def main(args: Array[String]): Unit = {
    val src = Source.fromResource("day/6/input")
    val data = try src.mkString finally src.close()

    val answersByGroups = data.split("\\n\\n").toList
    val countOfYesPerGroup = answersByGroups.map(_.split("\\n").flatMap(_.toList).toSet.size).sum
    println(f"number of questions to which anyone answered with 'yes': $countOfYesPerGroup")

    val countOfCommonYesPerGroup = answersByGroups.map(_.split("\\n").map(_.toSet).reduce(_ & _).size).sum
    println(f"number of questions to which everyone answered with 'yes': $countOfCommonYesPerGroup")
  }

}
