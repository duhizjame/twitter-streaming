package scala

import scala.configs.ConfigManager

object Main {
  def main(args: Array[String]): Unit = {
    val twitterConfig = ConfigManager.load match {
      case Left(error) => println(error.head)
      case Right(result) => result
    }
    println(twitterConfig)
  }
}
