package io.dolcefarniente.advent_of_code

import org.scalatest.FunSuite

class DayTwoTest extends FunSuite {

  test("PolicyOne") {
    assert(PolicyOneValidator.validate("1-3 a: abcde"))
    assert(PolicyOneValidator.validate("2-9 c: ccccccccc"))
    assert(!PolicyOneValidator.validate("1-3 b: cdefg"))
    assertThrows[IllegalArgumentException](PolicyOneValidator.validate("foo"))
  }

  test("PolicyTwo") {
    assert(PolicyOneValidator.validate("1-3 a: abcde"))
    assert(PolicyOneValidator.validate("2-9 c: ccccccccc"))
    assert(!PolicyOneValidator.validate("1-3 b: cdefg"))
  }

}
