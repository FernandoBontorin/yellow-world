package io.fernandobontorin.yellowworld.game

import io.fernandobontorin.yellowworld.elements.entities.{DotaRock, Persona, ScoreBoard, SoundBox}
import io.fernandobontorin.yellowworld.events.RandomEventGenerator

class Game {
  val dotaRock = new DotaRock
  val soundBox = new SoundBox
  val scoreBoard = new ScoreBoard
  val eventsGenerator = new RandomEventGenerator
  val persona = new Persona
}
