package io.fernandobontorin.yellowworld.elements.entities

import io.fernandobontorin.yellowworld.Main
import io.fernandobontorin.yellowworld.elements.Element

import java.awt.{Graphics, Point}

class Persona extends Element {

  val imageProvider = Main.resourceManager.getImageProvider("yellow-core")

  override def tick(): Unit = {}

  override def draw(graphics: Graphics): Unit =
    graphics.drawImage(
      imageProvider.getImage(),
      500 + 64, 500 - 64 - 32, 64+32, 64+32,
      null
    )

  override def isIn(point: Point): Boolean = false

  override def click(point: Point): Unit = ???
}
