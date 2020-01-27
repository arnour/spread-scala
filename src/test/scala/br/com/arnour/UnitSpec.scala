package br.com.arnour

import org.scalatest._
import org.scalatest.matchers.should.Matchers

import scala.io.Source

abstract class UnitSpec extends FlatSpec with Matchers with
  OptionValues with Inside with Inspectors {

  protected def str(d: Double, scale: Int = 12): String = {
    BigDecimal(d).setScale(scale, BigDecimal.RoundingMode.HALF_UP).toString()
  }

  protected def scale(d: Double, s: Int = 12): BigDecimal = {
    BigDecimal(d).setScale(s, BigDecimal.RoundingMode.HALF_UP)
  }

  protected def scale(d: String): BigDecimal = {
    scale(d.toDouble)
  }

  protected def quartile(values: Seq[Double], lower: Double): Double = {
    val sorted = values.sorted
    sorted(Math.round(values.length * lower / 100).toInt)
  }

  protected def streamResource(fileName: String) = {
    Source.fromInputStream(getClass.getResourceAsStream(fileName))
  }
}
