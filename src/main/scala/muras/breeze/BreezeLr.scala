package muras.breeze

import muras.share.TestData

import scala.io.Source

object BreezeLr {

  def main(args: Array[String]): Unit = {
    // weightsとbiasをファイルから読み込む
    val weightsSource = Source.fromFile("train_model/weights")
    val weightsString = weightsSource.getLines().toList.head
    val weightsList = weightsString.split(",").map(_.toDouble).toList
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

    // 前処理


    // 予測

  }

}
