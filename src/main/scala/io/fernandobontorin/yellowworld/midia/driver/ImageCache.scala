package io.fernandobontorin.yellowworld.midia.driver

import io.fernandobontorin.yellowworld.midia.images.{ImageProvider, LinkedImageProvider, UniqueImageProvider}
import io.fernandobontorin.yellowworld.midia.tools.assets
import org.apache.commons.lang3.StringUtils

import java.awt.Rectangle
import scala.collection.mutable

class ImageCache extends ResourceCache[ImageProvider] {
  private val images: mutable.Map[String, ImageProvider] = mutable.HashMap.empty

  {
    images.addOne(
      "dota2-logo",
      new UniqueImageProvider(assets("images/dota2-logo.png"), new Rectangle(24, 16, 72, 72))
    )
    images.addOne("box-sound", new UniqueImageProvider(assets("images/config/box-sound.png")))
    images.addOne("game-ready-button", new UniqueImageProvider(assets("images/events/dota-2-game-ready.jpg")))
    images.addOne(
      "yellow-core",
      new LinkedImageProvider(
        assets,
        (x: Int) => s"images/persona/yellow-core/frame_${StringUtils.leftPad(x.toString, 2, "0")}_delay-0.04s.png",
        0 to 84,
        (0.04 * 1000 / (1000.0 / 60)).toInt
      )
    )
  }

  override def query(s: String): ImageProvider =
    images.getOrElse(s, throw new NoSuchElementException(s"not found any image:$s"))
}
