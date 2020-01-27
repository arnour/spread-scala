package br.com.arnour

import java.util.UUID

import scala.io.Source

class SpreaderTest extends UnitSpec {

  "A Spreader" should "turn same String key into same Double value always" in {
    val key = "my-special-key-51f4c00e-7e77-4da8-8fbe-28c676cd179c"
    val expected = scale(0.842269196138)

    (1 to 1000).foreach {
      _ =>
        val result = Spread.Default.key(key)
        scale(result) should equal(expected)
    }
  }

  "A Spreader" should "distribute key almost-evenly" in {
    val values = (1 to 100000).map {
      _ =>
        val uuid = UUID.randomUUID().toString
        Spread.Default.key(uuid)
    }

    scale(quartile(values, 25), 2) should equal(scale(0.25, 2))
    scale(quartile(values, 50), 2) should equal(scale(0.50, 2))
    scale(quartile(values, 75), 2) should equal(scale(0.75, 2))
  }

  "A Spreader" should "keep compliant with spread go-lang" in {
    for (line <- Source.fromResource("sha1.txt").getLines()) {
      val parts = line.split(";")
      val result = Spread.SHA1.key(parts(0))
      scale(result) should equal(scale(parts(1)) +- 0.000000000001)
    }
  }
}
