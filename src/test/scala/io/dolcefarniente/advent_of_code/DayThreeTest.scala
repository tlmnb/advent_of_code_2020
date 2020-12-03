package io.dolcefarniente.advent_of_code

import org.scalatest.FunSuite

class DayThreeTest extends FunSuite {

  private val map = ("..##.......\n" +
    "#...#...#..\n" +
    ".#....#..#.\n" +
    "..#.#...#.#\n" +
    ".#...##..#.\n" +
    "..#.##.....\n" +
    ".#.#.#....#\n" +
    ".#........#\n" +
    "#.##...#...\n" +
    "#...##....#\n" +
    ".#..#...#.#").split("\\n").toList.map(_.toList)


  test("countTrees") {
    assert(DayThree.countTrees(map, 1) === 2)
    assert(DayThree.countTrees(map, 3) === 7)
    assert(DayThree.countTrees(map, 5) === 3)
    assert(DayThree.countTrees(map, 7) === 4)
    assert(DayThree.countTrees(map, 1, 2) === 2)
  }

}
