organization        := "io.fernandobontorin"
name                := "yellow-world"
ThisBuild / version := "0.1.0-SNAPSHOT"
scalaVersion        := "2.13.6"

libraryDependencies += "com.github.scopt"        %% "scopt"          % "4.0.1"
libraryDependencies += "com.googlecode.soundlibs" % "tritonus-share" % "0.3.7-2"
libraryDependencies += "com.googlecode.soundlibs" % "mp3spi"         % "1.9.5-1"
libraryDependencies += "com.googlecode.soundlibs" % "vorbisspi"      % "1.0.3-1"
libraryDependencies += "org.scalatest"           %% "scalatest"      % "3.2.9" % "test"

javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:+CMSClassUnloadingEnabled")
