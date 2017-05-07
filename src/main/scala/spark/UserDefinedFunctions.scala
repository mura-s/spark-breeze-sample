package spark

import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions.udf
import util.{FeatureHashingUtil, OneHotEncodeUtil}

object UserDefinedFunctions {

  val oneHotEncode: UserDefinedFunction = udf { (value: Int, numFeatures: Int) =>
    OneHotEncodeUtil.indexOf(value, numFeatures) match {
      case Some(index) => Vectors.sparse(numFeatures, Array(index), Array(1.0))
      case None        => Vectors.sparse(numFeatures, Array.empty[Int], Array.empty[Double])
    }
  }

  val featureHashing: UserDefinedFunction = udf { value: String =>
    val index = FeatureHashingUtil.indexOf(value)
    Vectors.sparse(FeatureHashingUtil.HashSize, Array(index), Array(1.0))
  }
}
