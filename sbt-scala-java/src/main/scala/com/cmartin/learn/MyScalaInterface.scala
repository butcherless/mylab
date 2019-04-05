package com.cmartin.learn

import scala.util.Try

trait MyScalaInterface {
  def convertStringToInt(s: String): Try[Int]
}
