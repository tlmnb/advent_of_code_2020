package io.dolcefarniente.advent_of_code


import scala.annotation.tailrec
import scala.io.Source

object DayFive {

  @tailrec
  def getRow(ch: Seq[Char], row: Range = 0 to 127): Int = ch match {
    case 'F'::t =>
      val lower = row.partition(_ <= (row.max + row.min)/2)._1
      getRow(t, lower.min to lower.max)
    case 'B'::t =>
      val upper = row.partition(_ <= (row.max + row.min)/2)._2
      getRow(t, upper.min to upper.max)
    case Nil => row.min
  }


  @tailrec
  def getColumn(ch: Seq[Char], seat: Range = 0 to 7): Int = ch match {
    case 'L'::t =>
      val lower = seat.partition(_ <= (seat.max + seat.min)/2)._1
      getColumn(t, lower.min to lower.max)
    case 'R'::t =>
      val upper = seat.partition(_ <= (seat.max + seat.min)/2)._2
      getColumn(t, upper.min to upper.max)
    case Nil => seat.min
  }


  def main(args: Array[String]): Unit = {
    val src = Source.fromResource("day/5/input")
    val data = try src.getLines().toList finally src.close()
    val splittedSeatPartitions = data.map(s => (s.slice(0,7) , s.slice(7, 10)))
    val maxSeatID = splittedSeatPartitions.map(t => getRow(t._1.toList) * 8 + getColumn(t._2.toList)).max
    println(f"Highest seat ID $maxSeatID")

    val myRowAndSeat = splittedSeatPartitions
      .groupBy(_._1)
      .filter(p => p._2.size == 7)

    val myRow = myRowAndSeat.head._1

    val mySeat = myRowAndSeat
      .head._2
      .map(t => getColumn(t._2.toList)).sorted.zip(0 to 7).find(t => t._1 != t._2).get._2

    val mySeatID = getRow(myRow.toList) * 8 + mySeat
    println(f"My Seat is $mySeatID")
  }

}
