package com.sarah

import cats.effect._
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.implicits._
import com.comcast.ip4s._

//point d entree de l application
//initialise le repo puis demarre le serveur http
object Main extends IOApp.Simple {

  def run: IO[Unit] =
    for {
      repo   <- ScoreRepo.inMemory[IO]
      routes  = new ScoreRoutes[IO](repo).routes

      _ <- EmberServerBuilder
            .default[IO]
            .withHost(ip"0.0.0.0")
            .withPort(port"8080")
            .withHttpApp(routes.orNotFound)
            .build
            .useForever
    } yield ()
}
