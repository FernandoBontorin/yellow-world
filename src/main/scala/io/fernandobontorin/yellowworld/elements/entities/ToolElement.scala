package io.fernandobontorin.yellowworld.elements.entities

import io.fernandobontorin.yellowworld.Main
import io.fernandobontorin.yellowworld.elements.Element
import io.fernandobontorin.yellowworld.elements.animated.Animation
import io.fernandobontorin.yellowworld.game.load.model.ToolModel

import java.awt.image.BufferedImage
import java.awt.{Graphics, Point}

class ToolElement(tool: ToolModel) extends Element with Animation{

  val defaultImage: BufferedImage = Main.resourceManager.getImageProvider("picareta").getImage()
  var running: Boolean = false
  var callback: () => Unit = _

  override def tick(): Unit = {}

  override def isIn(point: Point): Boolean = false

  override def click(point: Point): Unit = ???

  override def draw(graphics: Graphics): Unit = {
    graphics.drawImage(
      defaultImage,
      345, 340, 128, 128,
      null
    )
    graphics.drawImage(
      tool.imageProvider.getImage(),
      421, 373, 16, 16,
      null
    )
  }

  override def layer(): Int = 3

  override def startAnimation(callback: () => Unit): Unit = {
    if(!running){
      running = true
      this.callback = callback
    }
  }
}
