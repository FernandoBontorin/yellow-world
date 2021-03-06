package io.fernandobontorin.yellowworld.core

import io.fernandobontorin.yellowworld.Main

import java.awt.event.{MouseEvent, MouseListener}
import java.awt.{Canvas, Color, Dimension, Graphics}

class Display(dimension: Dimension) extends Canvas with Runnable with MouseListener {
  {
    this.setPreferredSize(dimension)
    this.addMouseListener(this)
  }

  override def run(): Unit = {
    if (this.getBufferStrategy == null) {
      this.createBufferStrategy(3)
    }
    val bs = this.getBufferStrategy

    val graphics: Graphics = bs.getDrawGraphics
    graphics.setColor(Color.BLACK)
    graphics.fillRect(0, 0, dimension.width, dimension.height)
    Main.elementManager.currentElements.sortBy(_.layer()).foreach(_.draw(graphics))
    graphics.dispose()
    bs.show()
  }

  override def mouseClicked(e: MouseEvent): Unit =
    Main.engine.pushClick(e)

  override def mousePressed(e: MouseEvent): Unit = {}

  override def mouseReleased(e: MouseEvent): Unit = {}

  override def mouseEntered(e: MouseEvent): Unit = {}

  override def mouseExited(e: MouseEvent): Unit = {}
}
