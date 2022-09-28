ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.9"
val AkkaVersion = "2.6.8"
val AkkaHttpVersion = "10.2.10"
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.30"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.13"
//libraryDependencies += "com.typesafe.play" %% "play-ws_2.11" % "2.3.3"
libraryDependencies += "io.github.hakky54" % "sslcontext-kickstart" % "7.4.6"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion
)
libraryDependencies += "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion
libraryDependencies +=  "com.softwaremill.sttp.client3" %% "core" % "3.8.0"
lazy val root = (project in file("."))
  .settings(
    name := "Scala_Codes"
  )
