ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.9"
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.30"

lazy val root = (project in file("."))
  .settings(
    name := "Scala_Codes"
  )
