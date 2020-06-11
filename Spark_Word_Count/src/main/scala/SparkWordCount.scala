package com.example.bigdata
import org.apache.spark.{SparkConf, SparkContext}
object SparkWordCount {

  def main(args: Array[String]) {
    val conf: SparkConf = new SparkConf()
      .setMaster("local")
      .setAppName("SparkWordCount")

    val sc: SparkContext = new SparkContext(conf)

    val regex = args(0).r
    println(regex)
    val cano = sc.textFile("file:///Users/michrata/Repo/priv-repo/Scala/Spark_Word_Count/cano.txt")
    val canoTokenized = cano.flatMap(_.split(" "))
    val canoWords = canoTokenized.map((_, 1)).filter {w => regex.findFirstIn(w._1).isDefined}
    val canoWordCounts = canoWords.reduceByKey(_ + _)
    val canoWordCountsTop10 = canoWordCounts.sortBy(_._2, ascending = false).take(10)
    System.out.println(canoWordCountsTop10.mkString(",\n"))
  }
}