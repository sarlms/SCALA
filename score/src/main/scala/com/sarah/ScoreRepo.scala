package com.sarah

import cats.effect._
import cats.effect.std._
import cats.syntax.all._

//definit les operations possibles sur les scores
trait ScoreRepo[F[_]] {
  def all: F[List[PlayerScore]]
  def add(score: PlayerScore): F[Unit]
  def clear: F[Unit]
}

//implementation en memoire pour simplifier le projet
object ScoreRepo {
  def inMemory[F[_]: Sync]: F[ScoreRepo[F]] =
    Ref.of[F, List[PlayerScore]](List()).map { ref =>
      new ScoreRepo[F] {

        //retourne tous les scores actuellement stockes
        override def all: F[List[PlayerScore]] =
          ref.get

        //ajoute un nouveau score a la fin de la liste
        override def add(score: PlayerScore): F[Unit] =
          ref.update(_ :+ score)

        //vide completement la liste des scores
        override def clear: F[Unit] =
          ref.set(List.empty)
      }
    }
}
