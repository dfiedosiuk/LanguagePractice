
import scala.io.StdIn.readLine
import scala.util.Random.shuffle

case class User(){

  def practice(scoreBoard: List[(String, String, Int)]): Seq[(String, String, Int)] = {
    val optionLang = readLine("Podaj opcje nauki 1-z Polskiego na Angielski, 2-z Angielskiego na Polski: ").toInt
    shuffle(scoreBoard).foldLeft(List.empty[(String, String, Int)]) { case (result, n) =>
      if (optionLang == 1) giveAnswer(n._1, n._2, n._3) +: result
      else  if (optionLang == 2) giveAnswer(n._2, n._1, n._3) +: result
      else{
        val error = println("Zle podana opcja! ")
        (n._1, n._2, n._3) +: result
      }
    }
  }
  def giveAnswer(reqWord: String, ansWord: String, score: Int): (String, String, Int) = {
    val answer = readLine(s"Podaj tlumaczenie slowa ${reqWord} : ")
    if (answer == ansWord) {
      println("Good answer!")
      (reqWord, ansWord, score + 1)
    }
    else {
      println(s"Bad answer! Correct answer is: ${ansWord}")
      (reqWord, ansWord, score)
    }
  }

}
