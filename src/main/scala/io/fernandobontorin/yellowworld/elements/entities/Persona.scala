package io.fernandobontorin.yellowworld.elements.entities

import io.fernandobontorin.yellowworld.Main
import io.fernandobontorin.yellowworld.elements.Element
import io.fernandobontorin.yellowworld.game.load.tools
import io.fernandobontorin.yellowworld.midia.images.ImageProvider

import java.awt.{Graphics, Point}

class Persona extends Element {

  val imageProvider: ImageProvider = Main.resourceManager.getImageProvider("yellow-core")
  var tool = new ToolElement(tools.firstTool())

  override def tick(): Unit = {}

  override def draw(graphics: Graphics): Unit =
    graphics.drawImage(
      imageProvider.getImage(),
      300, 380, 96, 96,
      null
    )

  override def isIn(point: Point): Boolean = false

  override def click(point: Point): Unit = ???

  override def layer(): Int = 1
}
