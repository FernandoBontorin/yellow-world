package io.fernandobontorin.yellowworld.midia.driver

import io.fernandobontorin.yellowworld.midia.audio.Audio
import io.fernandobontorin.yellowworld.midia.images.ImageProvider

class ResourceManager {
  private val images = new ImageCache
  private val sounds = new SoundCache
  def getImageProvider(s: String): ImageProvider = images.query(s)
  def getSound(s: String): Audio = sounds.query(s).apply()
  def playSound(s: String): Unit = sounds.query(s).apply().start()

}
