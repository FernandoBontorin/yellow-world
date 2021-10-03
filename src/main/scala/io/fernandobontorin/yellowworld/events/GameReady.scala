package io.fernandobontorin.yellowworld.events

import io.fernandobontorin.yellowworld.Main
import io.fernandobontorin.yellowworld.elements.Element
import io.fernandobontorin.yellowworld.elements.animations.LostMMR

import java.awt.{Graphics, Point, Rectangle, Shape}
import java.util.concurrent.atomic.AtomicInteger
import scala.math.{min, random}

class GameReady extends Element {
  Main.resourceManager.playSound("game-ready")
  val amount: Double = {
    Main.game.scoreBoard.currentScore * min(scala.math.max(0.25, random()), 0.1)
  }
  val ticksToAnim     = new AtomicInteger()
  val totalTicks: Int = 8 * 60
  val x: Int          = 20 + (random() * 400).toInt
  val y: Int          = 20 + (random() * 400).toInt
  val elementForm: Shape =
    new Rectangle(x, y, 240, 48)

  override def tick(): Unit =
    if (ticksToAnim.incrementAndGet() > totalTicks) {
      Main.resourceManager.playSound("lose")
      die()
    }

  override def draw(graphics: Graphics): Unit =
    graphics.drawImage(
      Main.resourceManager.getImage("game-ready-button"),
      x,
      y,
      240,
      48,
      null
    )

  override def isIn(point: Point): Boolean = elementForm.contains(point)

  override def click(point: Point): Unit = {
    Main.resourceManager.playSound("coin")
    Main.game.scoreBoard.enqueueTransaction(amount)
    new LostMMR
    die()
  }

}
