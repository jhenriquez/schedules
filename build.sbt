ThisBuild / scalaVersion := "2.12.13"

lazy val schedules = (project in file("."))
  .aggregate(core)
  .settings(
    name := "schedules",
  )

lazy val core = (project in file("core"))
    .settings(
        name := "schedules-core",
        libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.9",
        libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test,
        libraryDependencies += "org.scalatest" %% "scalatest-featurespec" % "3.2.9" % Test,
        Test / logBuffered := false,
    )
