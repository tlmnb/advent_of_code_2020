package io.dolcefarniente.advent_of_code

import org.scalatest.FunSuite

class DayFourTest extends FunSuite {

  test("parse passports") {
    val passportOne = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\nbyr:1937 iyr:2017 cid:147 hgt:183cm".split("[ \\n]")
    assert(DayFour.parse(passportOne) !== null)

    val passportTwo = "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\nhcl:#cfa07d byr:1929".split("[ \\n]")
    assert(DayFour.parse(passportTwo) === null)

    val passportThree = "hcl:#ae17e1 iyr:2013\neyr:2024\necl:brn pid:760753108 byr:1931\nhgt:179cm".split("[ \\n]")
    assert(DayFour.parse(passportThree) !== null)

    val passportFour = "hcl:#cfa07d eyr:2025 pid:166559648\niyr:2011 ecl:brn hgt:59in".split("[ \\n]")
    assert(DayFour.parse(passportFour) === null)
  }

  test("validate invalid passports") {
    val passportOne = DayFour.parse("eyr:1972 cid:100\nhcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926".split("[ \\n]"))
    assert(DayFour.validate(passportOne) === false)

    val passportTwo = DayFour.parse("iyr:2019\nhcl:#602927 eyr:1967 hgt:170cm\necl:grn pid:012533040 byr:1946".split("[ \\n]"))
    assert(DayFour.validate(passportTwo) === false)

    val passportThree = DayFour.parse("hcl:dab227 iyr:2012\necl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277".split("[ \\n]"))
    assert(DayFour.validate(passportThree) === false)

    val passportFour = DayFour.parse("hgt:59cm ecl:zzz\neyr:2038 hcl:74454a iyr:2023\npid:3556412378 byr:2007".split("[ \\n]"))
    assert(DayFour.validate(passportFour) === false)
  }

  test("validate valid passports") {
    val passportOne = DayFour.parse("pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980\nhcl:#623a2f".split("[ \\n]"))
    assert(DayFour.validate(passportOne) === true)

    val passportTwo = DayFour.parse("eyr:2029 ecl:blu cid:129 byr:1989\niyr:2014 pid:896056539 hcl:#a97842 hgt:165cm".split("[ \\n]"))
    assert(DayFour.validate(passportTwo) === true)

    val passportThree = DayFour.parse("hcl:#888785\nhgt:164cm byr:2001 iyr:2015 cid:88\npid:545766238 ecl:hzl\neyr:2022".split("[ \\n]"))
    assert(DayFour.validate(passportThree) === true)

    val passportFour = DayFour.parse("iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719".split("[ \\n]"))
    assert(DayFour.validate(passportFour) === true)
  }

}
