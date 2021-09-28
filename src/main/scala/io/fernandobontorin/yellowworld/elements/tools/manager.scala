package io.fernandobontorin.yellowworld.elements.tools

import io.fernandobontorin.yellowworld.elements.Element

import scala.collection.mutable

object manager {
  val elements: mutable.HashSet[Element] = mutable.HashSet.empty
  def register(e: Element): Unit = {
    synchronized(
      elements.add(e)
    )
    println("registered element " + e)
  }

  def undo(e: Element): Unit = {
    synchronized(
      elements.remove(e)
    )
    println("undo element " + e)
  }
}
