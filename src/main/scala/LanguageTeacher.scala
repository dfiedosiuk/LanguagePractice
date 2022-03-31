import java.io.{BufferedWriter, FileWriter}
import scala.collection.mutable.ListBuffer
import scala.io.Source

object LanguageTeacher extends App {
  val lines = Source.fromFile("dictionary.txt").getLines().toList
  val scoreLines = Source.fromFile("ScoreBoard.txt").getLines().toList
  val scoreBoard = scoreLines.map { line =>
    val Array(pWord, eWord, score) = line.split("\\s+")
    (pWord, eWord, score.toInt)
  }


  val student = new User
  //  val newScoreBoard = student.practice(scoreBoard)
  val newWords = ListBuffer.empty[(String,String)]
  student.addToDictionary(newWords).foreach(println)


  //  val writerDictionary = new BufferedWriter(new FileWriter("dictionary2.txt"))
  //  lines
  //    .map(line => (s"${line._1} ${line._2} ${line._3}").mkString("","","\n"))
  //    .foreach(writerScore.write)
  //  writerScore.close()

  //  val writerScore = new BufferedWriter(new FileWriter("ScoreBoard.txt"))
  //  newScoreBoard
  //    .map(line => (s"${line._1} ${line._2} ${line._3}").mkString("","","\n"))
  //    .foreach(writerScore.write)
  //  writerScore.close()


  //  practice(scoreBoard).foreach(println)

}
