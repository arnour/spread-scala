package br.com.arnour

import java.security.MessageDigest

object Spread {
  def newSpreader(algorithm: String = "SHA-256"): Spreader = new Spreader(MessageDigest.getInstance(algorithm))

  val SHA256 = new Spreader(MessageDigest.getInstance("SHA-256"))
  val SHA1 = new Spreader(MessageDigest.getInstance("SHA-1"))
  val Default = SHA256
}
