package muras.share.util

import scala.util.hashing.MurmurHash3

object FeatureHashingUtil {

  val hashSize: Int = Math.pow(2.0, 15.0).toInt

  def indexOf(value: String): Int = {
    def nonNegativeMod(v: Int, mod: Int): Int = {
      val rawMod = v % mod
      rawMod + (if (rawMod < 0) mod else 0)
    }

    val hash = MurmurHash3.stringHash(value)
    nonNegativeMod(hash, hashSize)
  }

}
