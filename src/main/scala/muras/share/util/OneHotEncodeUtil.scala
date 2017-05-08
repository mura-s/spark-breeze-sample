package muras.share.util

object OneHotEncodeUtil {

  def indexOf(value: Int, numFeatures: Int): Option[Int] =
    if (value < numFeatures) Some(value) else None

}
