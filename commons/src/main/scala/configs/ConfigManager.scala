package scala.configs

import pureconfig.ConfigReader.Result
import pureconfig._
import pureconfig.generic.auto._

object ConfigManager {
  val configPath = "commons/src/main/resources/application.conf"
  def load: Result[TwitterConfigurations] = ConfigSource.file(configPath).load[TwitterConfigurations]
}
