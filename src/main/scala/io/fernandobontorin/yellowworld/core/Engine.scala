package io.fernandobontorin.yellowworld.core

import io.fernandobontorin.yellowworld.Main

import java.awt.event.MouseEvent
import java.time.Instant
import java.util.concurrent.TimeUnit
import scala.collection.mutable

class Engine() extends Runnable {
  val clickStack: mutable.Stack[MouseEvent] = mutable.Stack()
  val tickTime: Long    = (TimeUnit.SECONDS.toNanos(1).toDouble / 60.toDouble).toLong
  var lastTick: Instant = current

  def pushClick(click: MouseEvent): Unit =
    clickStack.push(click)

  override def run(): Unit =
    while (true) {
      if (current.isAfter(lastTick.plusNanos(tickTime))) {
        lastTick = current
      if (clickStack.nonEmpty) {
        val click = clickStack.pop()
        val find  = Main.elementManager.currentElements.find(e => e.isIn(click.getPoint))
        if (find.nonEmpty) {
          find.get.click(click.getPoint)
        }
      }
        Main.elementManager.currentElements.foreach(_.tick())
        Main.display.run()
      }
    }

  def current: Instant = java.time.Instant.now()
}
