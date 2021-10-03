package io.fernandobontorin.yellowworld.elements

import io.fernandobontorin.yellowworld.Main
import io.fernandobontorin.yellowworld.core.engine.Tickle
import io.fernandobontorin.yellowworld.elements.graphics.Drawable
import io.fernandobontorin.yellowworld.elements.mappable.Interactive

abstract class Element extends Drawable with Tickle with Interactive {
  {
    Main.elementManager.register(this)
  }
  val id: Long = Main.elementManager.getIdentifier

  def die(): Unit = Main.elementManager.undo(this)

}
