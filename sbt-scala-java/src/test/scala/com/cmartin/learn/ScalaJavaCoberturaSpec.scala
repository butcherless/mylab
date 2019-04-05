package com.cmartin.learn

import org.scalatest._

import scala.util.{Failure, Success, Try}

class ScalaJavaCoberturaSpec extends FlatSpec with Matchers {

  val scalaImpl = MyScalaImplementation
  val javaImpl = new MyJavaImplementation

  val numberString = "123"
  val invalidNumberString = "n12"
  val expectedNumber = 123

  /*
  SCALA
   */

  it should "scala: convert a String to an Int" in {
    val result = scalaImpl.convertStringToInt(numberString)

    result shouldBe Success(expectedNumber)
  }

  it should "scala: get an Exception while converting a String to an Int" in {
    val result = scalaImpl.convertStringToInt(invalidNumberString)

    checkException(result) shouldBe true
  }


  /*
  JAVA
   */

  it should "java: convert a String to an Integer" in {
    val result = javaImpl.convertStringToInteger(numberString)

    result shouldBe expectedNumber
  }

  it should "java: get an Exception while converting a String to an Integer" in {
    val result = Try(javaImpl.convertStringToInteger(invalidNumberString))

    checkException(result) shouldBe true
  }


  def checkException(result: Try[_]): Boolean = {
    result match {
      case Failure(e) => e.isInstanceOf[NumberFormatException]
      case _ => false
    }
  }

}