package io.dolcefarniente.advent_of_code

import org.scalatest.FunSuite

class DayEightTest extends FunSuite {

  test("execute") {
    val program = DayEight.loadInstructions("nop +0\nacc +1\njmp +4\nacc +3\njmp -3\nacc -99\nacc +1\njmp -4\nacc +6")
    val (acc, trace) = DayEight.execute(program)
    assert(acc === 5)
    assert(trace === List(0, 1, 2, 6, 7, 3, 4))
  }

}
