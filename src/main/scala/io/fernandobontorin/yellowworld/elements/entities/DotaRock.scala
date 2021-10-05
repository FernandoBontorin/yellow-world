package io.fernandobontorin.yellowworld.elements.entities

import io.fernandobontorin.yellowworld.Main
import io.fernandobontorin.yellowworld.elements.Element

import java.awt.{Graphics, Point, Rectangle, Shape}

class DotaRock extends Element {

  val elementForm: Shape = new Rectangle(500 - 64, 500 - 64, 128, 128)

  override def tick(): Unit = {}

  override def draw(graphics: Graphics): Unit =
    graphics.drawImage(
      Main.resourceManager.getImageProvider("dota2-logo").getImage(),
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
    Main.game.scoreBoard.enqueueTransaction(1.toDouble)
    Main.game.persona.tool.startAnimation(()=>print("rotate"))
  }

  override def layer(): Int = 0
}
