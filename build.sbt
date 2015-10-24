lazy val root = (project in file(".")).
  settings(
    name := "SimpleFileIO",
    version := "1.0",
    scalaVersion := "2.11.4"
  )

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
    "com.github.scala-incubator.io" %% "scala-io-core" % "0.4.3-1",
    "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.3-1"
)