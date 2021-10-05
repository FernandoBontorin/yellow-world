package io.fernandobontorin.yellowworld.midia.images

import java.awt.image.BufferedImage

trait ImageProvider {

  def getImage(): BufferedImage

}
