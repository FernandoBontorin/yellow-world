package io.fernandobontorin.yellowworld.elements.animated

trait Animation {

  def startAnimation(callback: () => Unit): Unit
}
