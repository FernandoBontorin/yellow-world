package io.fernandobontorin.yellowworld.core

import io.fernandobontorin.yellowworld.Main
import io.fernandobontorin.yellowworld.elements.tools.manager

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
        val find  = manager.elements.find(e => e.isIn(click.getPoint))
        if (find.nonEmpty) {
          find.get.click(click.getPoint)
        }
      }
      manager.elements.foreach(_.tick())
        Main.display.run()
      }
    }

  def current: Instant = java.time.Instant.now()
}
