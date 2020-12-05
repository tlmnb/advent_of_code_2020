package io.dolcefarniente.advent_of_code

import scala.io.Source


case class Passport(byr: String, cid: Option[String], ecl: String, eyr: String, hcl: String, hgt: String, iyr: String, pid: String)


object DayFour {

  def parse(passport: Seq[String]): Passport = passport.sorted.map(_.split(":")).map(a => a(0) -> a(1)).toList match {
    case List(("byr", byr), ("cid", cid), ("ecl", ecl), ("eyr", eyr), ("hcl", hcl), ("hgt", hgt), ("iyr", iyr), ("pid", pid)) =>
      Passport(byr, Option(cid), ecl, eyr, hcl, hgt, iyr, pid)
    case List(("byr", byr), ("ecl", ecl), ("eyr", eyr), ("hcl", hcl), ("hgt", hgt), ("iyr", iyr), ("pid", pid)) =>
      Passport(byr, Option.empty, ecl, eyr, hcl, hgt, iyr, pid)
    case _ => null
  }

  private val byr = "((?:19[2-9][0-9])|(?:20[0-1][0-9])|(?:2020))".r
  private val ecl = "((?:amb)|(?:blu)|(?:brn)|(?:gry)|(?:grn)|(?:hzl)|(?:oth))".r
  private val eyr = "((?:202[0-9])|(?:2030))".r
  private val hgt = "((?:1[5-8][0-9]cm)|(?:19[0-3]cm)|(?:59in)|(?:6[0-9]in)|(?:7[0-6]in))".r
  private val hcl = "(#[0-9a-f]{6})".r
  private val iyr = "((?:201[0-9])|(?:2020))".r
  private val pid = "(\\d{9})".r

  def validate(passport: Passport): Boolean = passport match {
    case Passport(byr(_), _, ecl(_), eyr(_), hcl(_), hgt(_), iyr(_), pid(_))=> true
    case _ => false
  }


  def main(args: Array[String]): Unit = {
    val src = Source.fromResource("day/4/input")
    val data = try src.mkString finally src.close()

    val passports = data.split("\\n\\n").map(_.split("[ \\n]").toList).map(parse).toList.filter(_ != null)
    val numberOfPassports = passports.size
    println(f"number of passports in correct format: $numberOfPassports")

    val numberOfValidPassports = passports.map(validate).count(p => p)
    println(f"number of valid passports: $numberOfValidPassports")
  }

}
