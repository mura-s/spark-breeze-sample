package muras.spark

import org.apache.spark.sql.SparkSession

/**
  * SparkでLogistic Regressionの訓練と予測を行います。
  *
  * 実行方法:
  *   sbt assembly
  *   spark-submit --class muras.spark.SparkLr target/scala-2.11/spark-breeze-sample-assembly-1.0.jar
  */
object SparkLr {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("SparkLr")
      .getOrCreate()

    spark.sparkContext.setLogLevel("WARN")

    // WIP
    // load train data
    val df = spark.read
      .format("com.databricks.spark.csv")
      .load("data/train_data.csv")

    df.show(20, false)

    // preprocess


    // train


    // predict


    spark.stop()
  }

}
