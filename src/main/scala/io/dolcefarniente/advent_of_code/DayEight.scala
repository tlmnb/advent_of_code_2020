package io.dolcefarniente.advent_of_code

import scala.annotation.tailrec
import scala.io.Source

object DayEight {

  def loadInstructions(program: String): List[(String, Int, Boolean)] = {
    program.split("\\n").map(_.split(" ")).map(t => (t(0), t(1).toInt, false)).toList
  }

  @tailrec
  def execute(program: List[(String, Int, Boolean)], pos: Int = 0, acc: Int = 0, trace: List[Int] = List()): (Int, List[Int]) = {
    if(pos>=program.size) {
      return (acc, trace)
    }
    program(pos) match {
      case ("acc", arg, false) =>
        val updated = program.updated(pos, (program(pos)._1, program(pos)._2, true))
        execute(updated, pos+1, acc+arg, trace :+ pos)
      case ("jmp", arg, false) =>
        val updated = program.updated(pos, (program(pos)._1, program(pos)._2, true))
        execute(updated, pos+arg, acc, trace :+ pos)
      case ("nop", _, false) =>
        val updated = program.updated(pos, (program(pos)._1, program(pos)._2, true))
        execute(updated, pos+1, acc, trace :+ pos)
      case (_, _, true) =>
        (acc, trace)
      case (instruction, _, false) =>
        throw new IllegalStateException(s"got unknown instruction: $instruction")
    }
  }

  def main(args: Array[String]): Unit = {
    val src = Source.fromResource("day/8/input")
    val data = try src.mkString finally src.close()
    val program = loadInstructions(data)

    val (acc, trace) = execute(program)
    println(s"return value before entering infinite loop: $acc")

    val fixed = trace.filter(p => program(p)._1 == "nop" || program(p)._1 == "jmp").reverse.view.map { p =>
      val instruction = if(program(p)._1 == "nop") {
        "jmp"
      } else {
        "nop"
      }
      val updated = program.updated(p, (instruction, program(p)._2, false))
      execute(updated)
    }.collectFirst { case p if p._2.last == program.size -1 => p._1 }.get
    println(s"return value after eliminating the infinite loop: $fixed")
  }

}
