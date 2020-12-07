package io.dolcefarniente.advent_of_code

import scala.io.Source


object DaySeven {

  private val noOtherBags = "(.*?) bags contain no other bags.".r
  private val containBags = "(.*?) bags contain (.*?).".r

  def parseRule(rule: String): (String, Map[String, Int]) = rule match {
    case noOtherBags(color) => (color, Map())
    case containBags(color, bags) =>
      (color, bags.split(", ").toList.map(r => {
        val parts = r.split(" ")
        (parts(1) + " " + parts(2), parts(0).toInt)
      }).toMap)
  }


  def countBagColors(rules: Map[String, Map[String, Int]], color: String): Int = {
    def find(rules: Map[String, Map[String, Int]], color: String): Set[String] = {
      val filtered = rules.filter(t => t._2.contains(color)).keySet
      filtered union filtered.flatMap(t => find(rules, t))
    }
    find(rules, color).size
  }

  def countBags(rules: Map[String, Map[String, Int]], color: String): Int = {
    rules.getOrElse(color, Map()).map(t => t._2 + t._2 * countBags(rules, t._1)).sum
  }


  def main(args: Array[String]): Unit = {
    val src = Source.fromResource("day/7/input")
    val rules = try src.getLines().toList finally src.close()

    val parsedRules = rules.map(parseRule).toMap
    val bagColors = countBagColors(parsedRules, "shiny gold")
    println(f"$bagColors bag colors can contain at least one shiny gold bag")

    val bagsInShinyGoldBag = countBags(parsedRules, "shiny gold")
    println(f"$bagsInShinyGoldBag bgs are required inside one single shiny gold bag")
  }

}
