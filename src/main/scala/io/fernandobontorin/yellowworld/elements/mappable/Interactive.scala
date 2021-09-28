package io.fernandobontorin.yellowworld.elements.mappable
import java.awt.Point

trait Interactive {

  def isIn(point: Point): Boolean

  def click(point: Point): Unit

}
