package io.fernandobontorin.yellowworld.events

import io.fernandobontorin.yellowworld.elements.Element
import io.fernandobontorin.yellowworld.elements.animations.LostMMR
import io.fernandobontorin.yellowworld.elements.tools.manager
import io.fernandobontorin.yellowworld.game.provider
import io.fernandobontorin.yellowworld.midia.audio.sound_board
import io.fernandobontorin.yellowworld.midia.images.ImageCache

import java.awt.{Graphics, Point, Rectangle, Shape}
import java.util.concurrent.atomic.AtomicInteger
import scala.math.{min, random}

class GameReady extends Element with AutoCloseable {
  {
    sound_board.gameReady()
  }
  val amount: Double  = {
    provider.game.scoreBoard.currentScore * min(scala.math.max(0.25, random()), 0.1)
  }
  val ticksToAnim     = new AtomicInteger()
  val totalTicks: Int = 8 * 60
  val x: Int          = 20 + (random() * 400).toInt
  val y: Int          = 20 + (random() * 400).toInt
  val elementForm: Shape =
    new Rectangle(x, y, 240, 48)

  override def tick(): Unit =
    if (ticksToAnim.incrementAndGet() > totalTicks) {
      manager.undo(this)
      sound_board.lose()
      close()
    }

  override def close(): Unit = this.finalize()

  override def draw(graphics: Graphics): Unit =
    graphics.drawImage(
      cached.gameReadyButton,
      x,
      y,
      240,
      48,
      null
    )

  override def isIn(point: Point): Boolean = elementForm.contains(point)

  override def click(point: Point): Unit = {
    sound_board.coin()
    provider.game.scoreBoard.enqueueTransaction(amount)
    new LostMMR
    manager.undo(this)
    close()
  }
}
