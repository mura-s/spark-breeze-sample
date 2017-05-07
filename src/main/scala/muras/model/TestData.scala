package muras.model

// 各フィールドのの説明は TrainData.scala を参照
case class TestData(
  uid: String,
  hour: Int,
  advertiserId: Int,
  campaignId: Int,
  adId: Int,
  siteId: Int,
  c1: Int,
  c2: Int,
  n1: Double,
  n2: Double
)
