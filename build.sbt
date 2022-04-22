import sbt.fullRunTask

ThisBuild / scalaVersion     := "2.12.11"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "am.grid"
ThisBuild / organizationName := "bigdata-engineering"
ThisBuild / javacOptions     ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")
ThisBuild / scalacOptions    ++= Seq("-language:postfixOps")

lazy val produce: TaskKey[Unit] = taskKey[Unit]("Message Production")
lazy val consume: TaskKey[Unit] = taskKey[Unit]("Message Consumption")

lazy val root = (project in file("."))
  .settings(
    name := "kafka-application4s",
    resolvers += "Confluent Repo" at "https://packages.confluent.io/maven",
    resolvers += "Twitter" at "https://maven.twttr.com/",
    libraryDependencies ++= (Dependencies.rootDependencies ++ Dependencies.kafkaClientsDeps),
    libraryDependencies ++= (Dependencies.twitterAPIs ++ Dependencies.spark),
    libraryDependencies ++= (Dependencies.testDependencies map(_ % Test)),
    fullRunTask(produce, Compile, s"fr.ps.eng.kafka.app4s.client.ProducingApp"),
    fullRunTask(consume, Compile, s"fr.ps.eng.kafka.app4s.client.ConsumingApp")
  )