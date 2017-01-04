name := """shopping_cart"""

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"
libraryDependencies += "org.specs2" %% "specs2-core" % "3.8.6" % "test"

scalacOptions ++= Seq( "-unchecked", "-deprecation", "-feature" )
