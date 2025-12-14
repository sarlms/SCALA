ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "score",
    libraryDependencies ++= Seq(
      // Cats Effect
      "org.typelevel" %% "cats-effect" % "3.5.4",

      // Http4s
      "org.http4s" %% "http4s-ember-server" % "0.23.27",
      "org.http4s" %% "http4s-dsl" % "0.23.27",

      // Tapir
      "com.softwaremill.sttp.tapir" %% "tapir-core" % "1.10.0",
      "com.softwaremill.sttp.tapir" %% "tapir-http4s-server" % "1.10.0",
      "com.softwaremill.sttp.tapir" %% "tapir-json-circe" % "1.10.0",

      // Circe JSON
      "io.circe" %% "circe-generic" % "0.14.6",
      "io.circe" %% "circe-parser"  % "0.14.6",

      // Logging
      "ch.qos.logback" % "logback-classic" % "1.4.14",

      // Tests
      "org.typelevel" %% "munit-cats-effect" % "2.0.0" % Test
    )
  )
