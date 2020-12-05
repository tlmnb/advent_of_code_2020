package io.dolcefarniente.advent_of_code

import org.scalatest.FunSuite

class DayFiveTest extends FunSuite {

  test("getRow") {
    assert(DayFive.getRow("FBFBBFF".toList) === 44)
    assert(DayFive.getRow("BFFFBBF".toList) === 70)
    assert(DayFive.getRow("FFFBBBF".toList) === 14)
    assert(DayFive.getRow("BBFFBBF".toList) === 102)
  }

  test("getColumn") {
    assert(DayFive.getColumn("RLR".toList) === 5)
    assert(DayFive.getColumn("RRR".toList) === 7)
    assert(DayFive.getColumn("RLL".toList) === 4)
  }

}
