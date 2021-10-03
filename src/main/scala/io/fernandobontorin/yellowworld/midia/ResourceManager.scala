package io.fernandobontorin.yellowworld.midia

import io.fernandobontorin.yellowworld.midia.audio.{Audio, SoundCache}
import io.fernandobontorin.yellowworld.midia.images.ImageCache

import java.awt.image.BufferedImage

class ResourceManager {
  private val images = new ImageCache
  private val sounds = new SoundCache
  def getImage(s: String): BufferedImage = images.query(s)
  def getSound(s: String): Audio = sounds.query(s).apply()
  def playSound(s: String): Unit = sounds.query(s).apply().start()

}
