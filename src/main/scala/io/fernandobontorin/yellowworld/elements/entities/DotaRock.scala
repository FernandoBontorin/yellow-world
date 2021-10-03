package io.fernandobontorin.yellowworld.elements.entities

import io.fernandobontorin.yellowworld.Main
import io.fernandobontorin.yellowworld.elements.Element
import io.fernandobontorin.yellowworld.game.provider

import java.awt.image.BufferedImage
import java.awt.{Graphics, Point, Rectangle, Shape}

class DotaRock extends Element {

  val elementForm: Shape       = new Rectangle(500 - 64, 500 - 64, 128, 128)
  var logoState: BufferedImage = Main.resourceManager.getImage("dota2-logo")

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
    Main.resourceManager.playSound("coin")
    provider.game.scoreBoard.enqueueTransaction(1.toDouble)
  }
}
