package sample

import breeze.linalg.{DenseVector, SparseVector}
import breeze.numerics.sigmoid

/**
  * Breezeの動作確認用のコードです。
  * TODO: あとで消す
  */
object BreezeSample extends App {

  // DenseVector
  val w1 = DenseVector(-1.628998081132571, 0.008488040503005827, -0.09395971517916687)
  val x1 = DenseVector(-1.0, 1.5, 1.3)
  val bias1 = 1.6085311916097589
  val prob1 = sigmoid(w1.dot(x1) + bias1)
  println(prob1)

  // SparseVector
  val w2 = SparseVector(3)((0, -1.628998081132571), (1, 0.008488040503005827), (2, -0.09395971517916687))
  val x2 = SparseVector(3)((0, -1.0), (1, 1.5), (2, 1.3))
  val bias2 = 1.6085311916097589
  val prob2 = sigmoid(w2.dot(x2) + bias2)
  println(prob2)

}
