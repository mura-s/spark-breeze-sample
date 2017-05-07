package sample

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Sparkの動作確認用のコードです。
  * TODO: あとで消す
  *
  * 実行方法:
  *   sbt assembly
  *   spark-submit --class sample.SparkBasicWordCount target/scala-2.11/spark-breeze-sample-assembly-1.0.jar
  */
object SparkBasicWordCount extends App {
  val conf = new SparkConf().setAppName("BasicWordCount")
  val sc = new SparkContext(conf)

  val textFile = sc.textFile("/usr/local/Cellar/apache-spark/2.1.0/README.md")
  val words = textFile.flatMap(line => line.split(" "))
  val wordCounts = words.map(word => (word, 1)).reduceByKey((a, b) => a + b)

  wordCounts.collect().foreach(println(_))
}
