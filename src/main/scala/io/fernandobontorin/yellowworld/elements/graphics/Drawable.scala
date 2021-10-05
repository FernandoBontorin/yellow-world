package io.fernandobontorin.yellowworld.elements.graphics

import java.awt.Graphics

trait Drawable {

  def draw(graphics: Graphics): Unit

  def layer(): Int
}
