package io.fernandobontorin.yellowworld.elements.entities

import io.fernandobontorin.yellowworld.elements.Element

import java.awt.{Graphics, Point}

class MMRBoard extends Element{
  override def draw(graphics: Graphics): Unit = ???

  override def tick(): Unit = ???

  override def isIn(point: Point): Boolean = ???

  override def click(point: Point): Unit = ???

  override def layer(): Int = 10
}
