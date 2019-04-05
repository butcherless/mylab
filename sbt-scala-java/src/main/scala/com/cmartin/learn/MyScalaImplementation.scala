package com.cmartin.learn

import scala.util.Try

object MyScalaImplementation extends MyScalaInterface {
  override def convertStringToInt(s: String): Try[Int] = Try(s.toInt)
}
