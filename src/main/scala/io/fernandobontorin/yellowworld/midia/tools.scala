package io.fernandobontorin.yellowworld.midia

import java.io.{File, FileInputStream, InputStream}

object tools {

  def assets(s: String): InputStream    = new FileInputStream(new File("assets/" + s))
  def resources(s: String): InputStream = getClass.getResourceAsStream(s)

}
