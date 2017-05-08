package muras.breeze

import breeze.linalg.SparseVector
import breeze.numerics.sigmoid
import muras.share.TestData
import PreprocessHelper._

import scala.io.Source

/**
  * Breezeを使ってLogistic Regressionの予測を行います。
  */
object BreezeLr {

  def main(args: Array[String]): Unit = {
    // weightsとbiasをファイルから読み込む
    val weightsSource = Source.fromFile("train_model/weights")
    val weightsString = weightsSource.getLines().toList.head
    val weights = SparseVector(weightsString.split(",").map(_.toDouble))
    weightsSource.close()

    val biasSource = Source.fromFile("train_model/bias")
    val bias = biasSource.getLines().toList.head.toDouble
    biasSource.close()

    // テストデータを読み込む
    val testDataSource = Source.fromFile("data/test_data.csv")
    val testDataList = testDataSource.getLines().map { line =>
      val ary = line.split(",")
      TestData(
        uid          = ary(0),
        hour         = ary(1).toInt,
        advertiserId = ary(2).toInt,
        campaignId   = ary(3).toInt,
        adId         = ary(4).toInt,
        siteId       = ary(5).toInt,
        c1           = ary(6).toInt,
        c2           = ary(7).toInt,
        n1           = ary(8).toDouble,
        n2           = ary(9).toDouble)
    }.toList
    testDataSource.close()

    // 1件ずつ予測
    testDataList.foreach { data =>
      // 前処理
      val x = SparseVector.vertcat(
        featureHashing(data.uid),
        oneHotEncoding(data.hour, 23),
        oneHotEncoding(data.advertiserId, 10),
        oneHotEncoding(data.campaignId, 50),
        oneHotEncoding(data.adId, 100),
        oneHotEncoding(data.siteId, 100),
        oneHotEncoding(data.c1, 100),
        oneHotEncoding(data.c2, 100),
        SparseVector(Array(data.n1)),
        SparseVector(Array(data.n2))
      )

      // ロジスティック回帰で予測確率を計算
      val probability = sigmoid(bias + weights.dot(x))

      println(probability)
    }
  }

}
