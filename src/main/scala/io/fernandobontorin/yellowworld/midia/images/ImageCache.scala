package io.fernandobontorin.yellowworld.midia.images

import io.fernandobontorin.yellowworld.midia.ResourceCache
import io.fernandobontorin.yellowworld.midia.tools.assets

import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import scala.collection.mutable

class ImageCache extends ResourceCache[BufferedImage] {
  private val images: mutable.Map[String, BufferedImage] = mutable.HashMap.empty

  {
    images.addOne("dota2-logo", ImageIO.read(assets("images/dota2-logo.png")).getSubimage(24, 16, 72, 72))
    images.addOne("box-sound", ImageIO.read(assets("images/config/box-sound.png")))
    images.addOne("game-ready-button", ImageIO.read(assets("images/events/dota-2-game-ready.jpg")))
  }

  override def query(s: String): BufferedImage =
    images.getOrElse(s, throw new NoSuchElementException(s"not found any image:$s"))
}
