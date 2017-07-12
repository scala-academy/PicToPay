
lazy val commonSettings = Seq(
  organization := "com.github.scala-academy",
  version := "1.0",
  scalaVersion := "2.12.2",
  scalacOptions ++= Seq(
    "-encoding", "UTF-8",
    "-deprecation",
    "-feature",
    "-unchecked",
    "-Xfuture",
    "-Xlint",
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard",
    "-Ywarn-unused"
  ),
  libraryDependencies ++=
    commonLibraries ++
      testLibraries
)

lazy val testLibraries = {
  val scalaTestV = "3.0.1"
  Seq(
    "org.scalatest" %% "scalatest" % scalaTestV % "test"
  )
}

lazy val commonLibraries = {
  val catsV = "0.9.0"
  Seq(
    "org.typelevel" %% "cats" % catsV
  )
}

lazy val imageLibraries = {
  val scrimageV = "2.1.8"
  Seq(
    // for field image cropping
    "com.sksamuel.scrimage" %% "scrimage-filters" % scrimageV,
    "com.sksamuel.scrimage" %% "scrimage-core" % scrimageV,
    "com.sksamuel.scrimage" %% "scrimage-io-extra" % scrimageV
  )
}

lazy val picToPay = (project in file(".")).
  configs(IntegrationTest).
  settings(commonSettings: _*).
  settings(Defaults.itSettings: _*).
  settings(
    name := "Pic2Pay",
    libraryDependencies ++= imageLibraries
  )
