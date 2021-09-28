package io.fernandobontorin.yellowworld.elements.tools

import java.util.concurrent.atomic.AtomicLong

object identifier {

  val sessionId = new AtomicLong()

  def newId: Long = sessionId.incrementAndGet()

}
