package io.fernandobontorin.yellowworld.midia.driver

trait ResourceCache[A] {

  def query(s: String): A

}
