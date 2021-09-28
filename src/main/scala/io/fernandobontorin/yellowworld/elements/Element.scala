package io.fernandobontorin.yellowworld.elements

import io.fernandobontorin.yellowworld.core.engine.Tickle
import io.fernandobontorin.yellowworld.elements.graphics.Drawable
import io.fernandobontorin.yellowworld.elements.tools.identifier
import io.fernandobontorin.yellowworld.elements.mappable.Interactive

abstract class Element extends Drawable with Tickle with Interactive {
  {
    tools.manager.register(this)
  }
  val id: Long = identifier.newId

}
