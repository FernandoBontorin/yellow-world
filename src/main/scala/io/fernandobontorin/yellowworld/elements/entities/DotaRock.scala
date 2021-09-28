package io.fernandobontorin.yellowworld.elements.entities

import io.fernandobontorin.yellowworld.elements.Element
import io.fernandobontorin.yellowworld.game.provider
import io.fernandobontorin.yellowworld.midia.audio.sound_board
import io.fernandobontorin.yellowworld.midia.images.cached

import java.awt.image.BufferedImage
import java.awt.{Graphics, Point, Rectangle, Shape}

class DotaRock extends Element {

  val elementForm: Shape       = new Rectangle(500 - 64, 500 - 64, 128, 128)
  var logoState: BufferedImage = cached.dota_2_logo_resource

  override def tick(): Unit = {}

  override def draw(graphics: Graphics): Unit =
    graphics.drawImage(
      logoState,
      500 - 64,
      500 - 64,
      128,
      128,
      null
    )

  override def isIn(point: Point): Boolean =
    elementForm.contains(point)

  override def click(point: Point): Unit = {
    sound_board.coin()
    provider.game.scoreBoard.enqueueTransaction(1.toDouble)
  }
}
