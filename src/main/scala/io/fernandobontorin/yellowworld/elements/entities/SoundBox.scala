package io.fernandobontorin.yellowworld.elements.entities

import io.fernandobontorin.yellowworld.Main
import io.fernandobontorin.yellowworld.core.engine.config
import io.fernandobontorin.yellowworld.elements.Element

import java.awt.{Graphics, Point, Rectangle, Shape}

class SoundBox extends Element {

  val elementForm: Shape = new Rectangle(0, 800 - 36, 128, 36)
  val minus = new Rectangle(128-36-36, 800-36, 36, 36)
  val plus  = new Rectangle(128-36, 800-36, 36, 36)

  override def tick(): Unit = {}

  override def draw(graphics: Graphics): Unit =
    graphics.drawImage(Main.resourceManager.getImageProvider("box-sound").getImage(), 0, 800 - 36, 128, 36, null)

  override def isIn(point: Point): Boolean =
    elementForm.contains(point)

  override def click(point: Point): Unit = {
    if (minus.contains(point)) {
      config.decreaseDecibels()
    }
    if (plus.contains(point)) {
      config.increaseDecibels()
    }
  }

  override def layer(): Int = 0
}
