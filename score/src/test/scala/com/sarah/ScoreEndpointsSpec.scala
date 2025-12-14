package com.sarah

import cats.effect._
import munit.CatsEffectSuite

//tests simples pour verifier le comportement du repo des scores
class ScoreEndpointsSpec extends CatsEffectSuite {

  test("create + list scores") {
    for {
      repo <- ScoreRepo.inMemory[IO]
      _    <- repo.add(PlayerScore("alex", 1200, "hard"))
      all  <- repo.all
    } yield assertEquals(all.size, 1)
  }

  test("clear scores") {
    for {
      repo <- ScoreRepo.inMemory[IO]
      _    <- repo.add(PlayerScore("alex", 1200, "hard"))
      _    <- repo.clear
      all  <- repo.all
    } yield assertEquals(all.isEmpty, true)
  }
}
