package io.fernandobontorin.yellowworld.midia.images

import java.awt.Rectangle
import java.awt.image.BufferedImage
import java.io.InputStream
import javax.imageio.ImageIO

class UniqueImageProvider(asset: InputStream,
                          subset: Rectangle = new Rectangle(),
) extends ImageProvider {
  val content: BufferedImage = {
    if (subset.isEmpty) {
      ImageIO.read(asset)
    } else {
      ImageIO.read(asset).getSubimage(subset.x, subset.y, subset.width, subset.height)
    }
  }

  override def getImage(): BufferedImage = content
}
