package com.sarah

import cats.effect._
import cats.syntax.all._
import org.http4s.HttpRoutes
import sttp.tapir.server.http4s._
import sttp.tapir.server.http4s.Http4sServerInterpreter

//relie les endpoints tapir a la logique metier
class ScoreRoutes[F[_]: Async](repo: ScoreRepo[F]) {

  //route get qui renvoie tous les scores
  private val getRoute =
    ScoreEndpoints.getScores.serverLogic { _ =>
      repo.all.map(Right(_))
    }

  //route post qui ajoute un score
  private val postRoute =
    ScoreEndpoints.createScore.serverLogic { score =>
      repo.add(score).as(Right("score added"))
    }

  //route delete qui vide tous les scores
  private val deleteRoute =
    ScoreEndpoints.deleteScores.serverLogic { _ =>
      repo.clear.as(Right("scores cleared"))
    }

  //expose toutes les routes http
  val routes: HttpRoutes[F] =
    Http4sServerInterpreter[F]()
      .toRoutes(List(getRoute, postRoute, deleteRoute))
}
