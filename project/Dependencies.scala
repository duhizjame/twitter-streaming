import sbt._

object Dependencies {

  lazy val rootDependencies: List[ModuleID] =
    "org.typelevel" %% "cats-core" % "2.1.1" ::
      "ch.qos.logback" % "logback-classic" % "1.2.3" ::
      "com.github.pureconfig" %% "pureconfig" % "0.17.1" ::
      "com.sksamuel.avro4s" %% "avro4s-core" % "3.1.1" ::
      "com.nrinaudo" %% "kantan.csv" % "0.6.1" ::
      "com.nrinaudo" %% "kantan.csv-enumeratum" % "0.6.1" ::
      "com.google.code.gson" % "gson" % "2.8.5" :: Nil

  lazy val twitterAPIs: List[ModuleID] =
    "com.twitter" % "twitter-api-java-sdk" % "1.1.2" :: Nil

  lazy val spark: List[ModuleID] =
    "org.apache.spark" %% "spark-core" % "2.4.4" ::
      "org.apache.spark" %% "spark-sql" % "2.4.4" ::
      "org.apache.spark" %% "spark-streaming" % "2.4.4" :: Nil

  lazy val kafkaClientsDeps: List[ModuleID] =
    "org.apache.kafka" % "kafka-clients" % "2.6.0" ::
      "io.confluent" % "kafka-avro-serializer" % "6.0.0" :: Nil

  lazy val testDependencies: List[ModuleID] =
    "org.scalatest" %% "scalatest" % "3.2.3" ::
      "org.scalactic" %% "scalactic" % "3.2.3" ::
      "org.scalacheck" %% "scalacheck" % "1.15.1" ::
      "org.typelevel" %% "cats-core" % "2.3.0" :: Nil
}