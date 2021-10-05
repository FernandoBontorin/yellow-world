package io.fernandobontorin.yellowworld.midia.images

import java.awt.image.BufferedImage
import java.io.InputStream
import javax.imageio.ImageIO

class LinkedImageProvider(
    resourceReaderFunction: String => InputStream,
    frameNameFunction: Int => String,
    range: Range.Inclusive,
    ticksToNext: Int
) extends ImageProvider {
  private val frames: Map[Int, BufferedImage] =
    range.map(value => value -> ImageIO.read(resourceReaderFunction(frameNameFunction(value)))).toMap

  val keys: Seq[Int] = frames.keys.toSeq.sorted
  private var pointer     = keys.head
  private var currentTick = 0

  override def getImage(): BufferedImage = {
    if (currentTick > ticksToNext) {
      if (pointer == keys.reverse.head) {
        pointer = keys.head
      } else {
        pointer = keys.dropWhile(_ <= pointer).head
      }
      currentTick = 0
    }
    currentTick += 1
    frames(pointer)
  }
}
