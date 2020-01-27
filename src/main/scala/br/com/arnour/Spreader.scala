package br.com.arnour

import java.nio.ByteBuffer
import java.security.MessageDigest

import br.com.arnour.Spreader._

object Spreader {
  private val MinValue: Double = Int.MinValue.toDouble
  private val RangeValue: Double = Int.MaxValue.toDouble - MinValue
  private val UpperBound: Double = 1.0
  private val LowerBound: Double = 0.0
}

class Spreader(digest: MessageDigest) {
  def key(key: String): Double = Some(key)
    .map(bytes)
    .map(_.getInt())
    .map(fraction)
    .map(bound)
    .getOrElse(LowerBound)

  private def bytes(key: String): ByteBuffer = {
    digest.reset()
    digest.update(key.getBytes("utf8"))
    ByteBuffer.wrap(digest.digest().slice(0, 4))
  }

  private def fraction(i: Int): Double = {
    (i - MinValue) / RangeValue
  }

  private def bound(fraction: Double): Double = {
    fraction.min(UpperBound).max(LowerBound)
  }
}
