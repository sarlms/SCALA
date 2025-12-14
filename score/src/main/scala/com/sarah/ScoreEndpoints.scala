package com.sarah

import sttp.tapir._
import sttp.tapir.generic.auto._
import sttp.tapir.json.circe._
import io.circe.generic.auto._

//definition des endpoints http exposes par l api
object ScoreEndpoints {

  //chemin de base pour les scores
  val base = "scores"

  //endpoint get pour recuperer tous les scores
  val getScores = endpoint.get
    .in(base)
    .out(jsonBody[List[PlayerScore]])

  //endpoint post pour creer un nouveau score
  val createScore = endpoint.post
    .in(base)
    .in(jsonBody[PlayerScore])
    .out(stringBody)

  //endpoint delete pour supprimer tous les scores
  val deleteScores = endpoint.delete
    .in(base)
    .out(stringBody)
}
