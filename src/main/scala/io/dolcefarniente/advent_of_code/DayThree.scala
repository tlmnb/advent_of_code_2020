package io.dolcefarniente.advent_of_code

import scala.io.Source


object DayThree {

  def countTrees(baseMap: List[List[Char]], right: Int, down: Int = 1): Int = {
    (baseMap.indices by down).map(i => {
      val next = ((i / down) * right) % baseMap(i).length
      baseMap(i)(next)
    }).count(_ == '#')
  }


  def main(args: Array[String]): Unit = {
    val src = Source.fromResource("day/3/input")
    val lines = try src.getLines().toList finally src.close()

    val baseMap = lines.map(_.toList)


    val trees = countTrees(baseMap, 3)
    println(f"First Puzzle: $trees")

    val productOfTrees = List(countTrees(baseMap, 1),
      countTrees(baseMap, 3),
      countTrees(baseMap, 5),
      countTrees(baseMap, 7),
      countTrees(baseMap, 1, 2)).product

    println(f"Second Puzzle: $productOfTrees")
  }

}
