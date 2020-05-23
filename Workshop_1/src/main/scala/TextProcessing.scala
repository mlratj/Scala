import scala.collection.mutable
import scala.io.Source
import scala.collection.mutable.Map

object TextProcessing extends App{
  val file = "http://www.textfiles.com/etext/AUTHORS/DOYLE/doyle-hound-383.txt"
  val html = Source.fromURL(file)
  val s = html.mkString.replaceAll("""[\p{Punct}]""", "").toLowerCase()
  val tokens = s.split("\\W+").toList
  val words = tokens.groupBy(w => w).mapValues(_.size).toMap
  val words_seq = words.toSeq
  val words_sorted = words_seq.sortWith(_._2 > _._2)
  println(words_sorted)
  val murder = words_seq.filter(_._1 == "murder").map(_._2).mkString("")
  val scream = words_seq.filter(_._1 == "scream").map(_._2).mkString("")
  val Watson = words_seq.filter(_._1 == "watson").map(_._2).mkString("")
  println(s"Word 'murder' appears $murder times.")
  println(s"Word 'scream' appears $scream times.")
  println(s"Word 'Watson' appears $Watson times.")
}
