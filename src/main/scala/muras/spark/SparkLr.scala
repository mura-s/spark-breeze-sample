package muras.spark

import muras.share.model.TrainData
import muras.spark.PreprocessHelper._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, lit}
import org.apache.spark.sql.types._

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

    import spark.implicits._

    // 訓練データのスキーマ
    val schema = StructType(Array(
      StructField("label", DoubleType, false),
      StructField("uid", StringType, false),
      StructField("hour", IntegerType, false),
      StructField("advertiserId", IntegerType, false),
      StructField("campaignId", IntegerType, false),
      StructField("adId", IntegerType, false),
      StructField("siteId", IntegerType, false),
      StructField("c1", IntegerType, false),
      StructField("c2", IntegerType, false),
      StructField("n1", DoubleType, false),
      StructField("n2", DoubleType, false)
    ))

    // 訓練データをロード
    val trainDs = spark.read
      .format("com.databricks.spark.csv")
      .schema(schema)
      .load("data/train_data.csv")
      .as[TrainData]

    // 訓練データの前処理
    val preprocessedTrainDs = trainDs
      .select(
        col("label")                                as "label",
        featureHashing(col("uid"))                  as "uid",
        oneHotEncode(col("hour"),         lit(23))  as "hour",
        oneHotEncode(col("advertiserId"), lit(10))  as "advertiserId",
        oneHotEncode(col("campaignId"),   lit(50))  as "campaignId",
        oneHotEncode(col("adId"),         lit(100)) as "adId",
        oneHotEncode(col("siteId"),       lit(100)) as "siteId",
        oneHotEncode(col("c1"),           lit(100)) as "c1",
        oneHotEncode(col("c2"),           lit(100)) as "c2",
        col("n1")                                   as "n1",
        col("n2")                                   as "n2"
      )
      .as[PreprocessedTrainData]

    preprocessedTrainDs.show(20, false)

    // 訓練


    // 予測


    spark.stop()
  }

}
