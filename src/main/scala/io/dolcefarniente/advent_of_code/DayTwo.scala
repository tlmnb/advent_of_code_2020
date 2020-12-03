package io.dolcefarniente.advent_of_code

import scala.io.Source

trait PasswordPolicyValidator {

  private val pwdRegex = "(\\d+)-(\\d+) (.): (.+)".r

  def validate(pwd: String): Boolean = {
    pwd match {
      case pwdRegex(min, max, letter, p) => policy(min.toInt, max.toInt, letter(0), p)
      case _ => throw new IllegalArgumentException(f"could not parse password")
    }
  }

  def policy(min: Int, max: Int, letter: Char, password: String): Boolean
}


object PolicyOneValidator extends PasswordPolicyValidator {

  override def policy(min: Int, max: Int, letter: Char, password: String): Boolean = {
    (min to max).contains(password.count(_ == letter))
  }

}


object PolicyTwoValidator extends PasswordPolicyValidator {

  override def policy(min: Int, max: Int, letter: Char, password: String): Boolean = {
    password(min-1) == letter ^ password(max-1) == letter
  }

}


object DayTwo {

  def main(args: Array[String]): Unit = {
    val src = Source.fromResource("day/2/input")
    val passwords = try src.getLines().toList finally src.close()
    val policyOneCorrect = passwords.count(PolicyOneValidator.validate)
    println(f"for policy one, $policyOneCorrect correct passwords were found")
    val policyTwoCorrect = passwords.count(PolicyTwoValidator.validate)
    println(f"for policy two, $policyTwoCorrect correct passwords were found")
  }

}
