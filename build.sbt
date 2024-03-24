
lazy val commonSettings = Seq(
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "3.3.0",
  //crossScalaVersions := Seq("3.4.0", "2.13.12"),

  libraryDependencies += "org.jetbrains.kotlin" % "kotlin-stdlib" % "1.9.23",
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.17" % Test,
  libraryDependencies += "org.scala-lang" %% "scala3-tasty-inspector" % scalaVersion.value,
  scalacOptions += "-Yretain-trees"

)

lazy val root = (project in file("."))
  .aggregate(core, stdlib)
  .settings(
    commonSettings,
  )

lazy val core = (project in file("core"))
  .settings(
    commonSettings,
  )

lazy val stdlib = (project in file("stdlib"))
  .settings(
    commonSettings,
  )