package io.fernandobontorin.yellowworld.events

import io.fernandobontorin.yellowworld.elements.Element

import java.awt.{Graphics, Point}

class RandomEventGenerator extends Element {
  override def tick(): Unit = {
    if(scala.math.random()*10000 > 9995){
      new GameReady
    }
  }

  override def draw(graphics: Graphics): Unit = {}

  override def isIn(point: Point): Boolean = false

  override def click(point: Point): Unit = ???
}
