package io.fernandobontorin.yellowworld.elements.animated.operation

import java.awt.image.BufferedImage

class Rotate(degree: Int, image: BufferedImage) {

  import java.awt.geom.AffineTransform
  import java.awt.image.{AffineTransformOp, BufferedImage}

  val rads: Double = Math.toRadians(degree)
  val sin: Double = Math.abs(Math.sin(rads))
  val cos: Double = Math.abs(Math.cos(rads))
  val w: Int = Math.floor(image.getWidth * cos + image.getHeight * sin).toInt
  val h: Int = Math.floor(image.getHeight * cos + image.getWidth * sin).toInt
  val rotatedImage = new BufferedImage(w, h, image.getType)
  val at = new AffineTransform
  at.translate(w / 2, h / 2)
  at.rotate(rads, 0, 0)
  at.translate(-image.getWidth / 2, -image.getHeight / 2)
  val rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR)
  rotateOp.filter(image, rotatedImage)

}
