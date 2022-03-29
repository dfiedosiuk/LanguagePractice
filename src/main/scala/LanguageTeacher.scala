import java.io.{BufferedWriter, FileWriter}
import scala.io.Source

object LanguageTeacher extends App {
  val lines = Source.fromFile("dictionary.txt").getLines().toList
  val scoreLines = Source.fromFile("ScoreBoard.txt").getLines().toList
  val scoreBoard = scoreLines.map { line =>
    val Array(pWord, eWord, score) = line.split("\\s+")
    (pWord, eWord, score.toInt)
  }

  val student = new User
  val newScoreBoard = student.practice(scoreBoard)

  val file = "ScoreBoard.txt"
  val writer = new BufferedWriter(new FileWriter(file))
  newScoreBoard
    .map(line => (s"${line._1} ${line._2} ${line._3}").mkString("","","\n"))
    .foreach(writer.write)
  writer.close()

//  practice(scoreBoard).foreach(println)

}
