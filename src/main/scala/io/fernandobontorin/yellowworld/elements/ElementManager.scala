package io.fernandobontorin.yellowworld.elements

import java.util.concurrent.atomic.AtomicLong
import scala.collection.mutable

class ElementManager {
  private val elementSessionId                   = new AtomicLong()
  private val elements: mutable.HashSet[Element] = mutable.HashSet.empty

  def getIdentifier: Long = elementSessionId.incrementAndGet()

  def register(e: Element): Unit =
    synchronized(
      elements.add(e)
    )

  def undo(e: Element): Unit =
    synchronized(
      elements.remove(e)
    )

  def currentElements: Seq[Element] = elements.toSeq
}
