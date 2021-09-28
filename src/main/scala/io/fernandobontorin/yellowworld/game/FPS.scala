package io.fernandobontorin.yellowworld.game

import io.fernandobontorin.yellowworld.elements.Element

import java.awt.{Graphics, Point}
import java.time.Instant
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import javax.swing.JFrame

class FPS(frame: JFrame) extends Element{
  def current: Instant = java.time.Instant.now()
  var lastSecond: Instant = current
  val tickTime: Long    = TimeUnit.SECONDS.toNanos(1)
  var lastFPS = 0
  var sessionId = new AtomicInteger()
  def nextFrame: Int = sessionId.incrementAndGet()

  override def tick(): Unit = {
  }

  override def draw(graphics: Graphics): Unit = {
    if (current.isAfter(lastSecond.plusNanos(tickTime))) {
      lastSecond = current
      lastFPS = nextFrame
      sessionId = new AtomicInteger()
    }
    nextFrame
    frame.setTitle(f"Yellow World ($lastFPS)")
  }

  override def isIn(point: Point): Boolean = false

  override def click(point: Point): Unit = ???
}
