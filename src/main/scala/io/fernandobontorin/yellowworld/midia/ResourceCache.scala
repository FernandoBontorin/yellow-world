package io.fernandobontorin.yellowworld.midia

trait ResourceCache[A] {

  def query(s: String): A

}
