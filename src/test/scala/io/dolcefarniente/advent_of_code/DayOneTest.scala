package io.dolcefarniente.advent_of_code

import org.scalatest.FunSuite

class DayOneTest extends FunSuite {

  test("DayOne.compute") {
    val l = List(1721, 979, 366, 299, 675, 1456)
    assert(DayOne.compute(l, 2) === 514579)
    assert(DayOne.compute(l, 3) === 241861950)
  }

  test("DayOne.compute returns 0 when l is empty") {
    assert(DayOne.compute(List(), 2) === 0)
    assert(DayOne.compute(List(), 3) === 0)
  }

}
