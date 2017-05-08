package muras.breeze

import breeze.linalg.SparseVector
import muras.share.util.{FeatureHashingUtil, OneHotEncodeUtil}

object PreprocessHelper {

  def oneHotEncoding(value: Int, numFeatures: Int): SparseVector[Double] = {
    OneHotEncodeUtil.indexOf(value, numFeatures) match {
      case Some(index)  => SparseVector(numFeatures)((index, 1.0))
      case None         => SparseVector.zeros(numFeatures)
    }
  }

  def featureHashing(value: String): SparseVector[Double] = {
    val index = FeatureHashingUtil.indexOf(value)
    SparseVector(FeatureHashingUtil.hashSize)((index, 1.0))
  }

}
