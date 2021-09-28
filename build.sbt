organization := "io.fernandobontorin"
name := "yellow-world"
ThisBuild / version := "0.1.0-SNAPSHOT"
scalaVersion := "2.13.6"

libraryDependencies += "com.github.scopt" %% "scopt" % "4.0.1"
libraryDependencies += "fr.delthas" % "javamp3" % "1.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % "test"
javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:+CMSClassUnloadingEnabled")