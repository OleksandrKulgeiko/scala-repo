
name := "scala-hello"

version := "1.0"

scalaVersion := "2.12.7"

scalacOptions ++= Seq("-unchecked", "-deprecation")

resolvers += ("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/")

libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-actor_2.12" % "2.5.0"
)
