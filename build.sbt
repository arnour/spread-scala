lazy val scala212 = "2.12.10"
lazy val scala211 = "2.11.12"
lazy val supportedScalaVersions = List(scala212, scala211)

organization in ThisBuild := "br.com.arnour"
scalaVersion in ThisBuild := "2.13.1"
name in ThisBuild := "spread-scala"

homepage := Some(url("https://github.com/arnour/spread-scala"))
scmInfo := Some(ScmInfo(url("https://github.com/arnour/spread-scala"), "git@github.com:arnour/spread-scala.git"))
developers := List(Developer("arnour", "Arnour Sabino", "arnour.sabino@gmail.com", url("https://github.com/username")))
crossScalaVersions := supportedScalaVersions
publishMavenStyle := true
publishArtifact in Test := false
pomIncludeRepository := { _ => false}
publishTo in ThisBuild := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))
libraryDependencies += "org.scalactic" %% "scalactic" % "3.1.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % "test"