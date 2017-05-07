package muras.spark

import org.apache.spark.sql.SparkSession

object SparkLr {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("SparkLr")
      .getOrCreate()

    spark.sparkContext.setLogLevel("WARN")

    // WIP
    // load train data


    // preprocess


    // train


    // predict


    spark.stop()
  }

}
