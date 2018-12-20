
/*
Compatible versions
scalaVersion := "2.12.7"
"com.typesafe.akka" % "akka-actor_2.12" % "2.5.0"
---
scalaVersion := "2.12.7"
"com.typesafe.akka" %% "akka-actor" % "2.5.0",
"com.typesafe.akka" %% "akka-camel" % "2.5.18"
*/


name := "scala-hello"

version := "1.0"

scalaVersion := "2.11.5"

scalacOptions ++= Seq("-unchecked", "-deprecation")

resolvers += ("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.0",
  "com.typesafe.akka" %% "akka-camel" % "2.5.18",
  "com.typesafe.akka" %% "akka-stream" % "2.5.0",
  "com.typesafe.akka" %% "akka-http-core"  % "2.4.11",
  "com.typesafe.akka" %% "akka-http-experimental"  % "2.4.11",
  "com.typesafe.akka" %% "akka-http-spray-json-experimental"  % "2.4.11"
)
