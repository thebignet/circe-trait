name := "test-json-trait"

version := "0.1"

scalaVersion := "2.12.4" // Scala 2.11/12

val circeVersion = "0.9.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-generic-extras",
  "io.circe" %% "circe-parser",
  "io.circe" %% "circe-shapes"
).map(_ % circeVersion)

libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.0.5" % Test)