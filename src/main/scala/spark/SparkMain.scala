package spark

import org.apache.spark.sql.SparkSession

object SparkMain {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("Basic LrHashAndOnehotEnc")
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
