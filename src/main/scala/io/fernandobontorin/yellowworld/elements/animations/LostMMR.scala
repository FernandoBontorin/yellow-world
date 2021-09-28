package io.fernandobontorin.yellowworld.elements.animations

import io.fernandobontorin.yellowworld.elements.Element
import io.fernandobontorin.yellowworld.elements.tools.manager

import java.awt.{Color, Font, Graphics, Point}
import java.util.concurrent.atomic.AtomicInteger
import scala.math.{max, random}

class LostMMR extends Element with AutoCloseable{
  val amount: Double = 16 + (random() * 15).toInt
  val ticksToAnim = new AtomicInteger()
  val totalTicks: Int = 3*60
  val font = new Font(Font.SANS_SERIF, Font.ITALIC, 18)
  def fade: Float = {
    max(1 - scala.math.max(ticksToAnim.get()-2, 1).toFloat/totalTicks.toFloat, 0.1f)
  }
  def color: Color = new Color(1, 0, 0, fade)
  val x: Int = 200 + (random() * 400).toInt
  val yInitial: Int = totalTicks + 1 + (random() * 200).toInt

  def y: Int = yInitial + ticksToAnim.get()


  override def tick(): Unit = {
    if(ticksToAnim.incrementAndGet() > totalTicks){
      manager.undo(this)
      close()
    }
  }

  override def draw(graphics: Graphics): Unit = {
    graphics.setColor(color)
    graphics.setFont(font)
    graphics.drawString(f"- $amount MMR", x, y)
  }

  override def isIn(point: Point): Boolean = false

  override def click(point: Point): Unit = ???

  override def close(): Unit = {
    this.finalize()
  }
}
