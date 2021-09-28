package io.fernandobontorin.yellowworld.midia.images

import io.fernandobontorin.yellowworld.midia.tools.assets

import java.awt.image.BufferedImage
import javax.imageio.ImageIO

object cached {
  val dota_2_logo_resource: BufferedImage = ImageIO.read(assets("images/dota2-logo.png")).getSubimage(24, 16, 72, 72)
  val soundBox: BufferedImage = ImageIO.read(assets("images/config/box-sound.png"))
  val gameReadyButton: BufferedImage = ImageIO.read(assets("images/events/dota-2-game-ready.jpg"))

  def init(): Unit = {}

}
