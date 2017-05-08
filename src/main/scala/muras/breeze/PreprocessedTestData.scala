package muras.breeze

import breeze.linalg.SparseVector

case class PreprocessedTestData(
  uid: SparseVector[Double],
  hour: SparseVector[Double],
  advertiserId: SparseVector[Double],
  campaignId: SparseVector[Double],
  adId: SparseVector[Double],
  siteId: SparseVector[Double],
  c1: SparseVector[Double],
  c2: SparseVector[Double],
  n1: Double,
  n2: Double
)
