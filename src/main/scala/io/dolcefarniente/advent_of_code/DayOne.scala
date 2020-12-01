package io.dolcefarniente.advent_of_code

import scala.io.Source

object DayOne {

  def compute(l: List[Int], n: Int): Int = {
    l.combinations(n).filter(_.sum == 2020).nextOption().getOrElse(List(0)).product
  }

  def main(args: Array[String]): Unit = {
    val src = Source.fromResource("day/1/input")
    val expenses = try src.getLines().map(_.toInt).toList finally src.close()

    println(compute(expenses, 2))
    println(compute(expenses, 3))
  }

}
