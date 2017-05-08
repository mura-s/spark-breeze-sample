package muras.spark

import org.apache.spark.ml.linalg.Vector

case class PreprocessedTestData(
  uid: Vector,
  hour: Vector,
  advertiserId: Vector,
  campaignId: Vector,
  adId: Vector,
  siteId: Vector,
  c1: Vector,
  c2: Vector,
  n1: Double,
  n2: Double
)
