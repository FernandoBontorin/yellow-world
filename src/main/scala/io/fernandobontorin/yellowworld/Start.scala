package io.fernandobontorin.yellowworld

import io.fernandobontorin.yellowworld.core.{Display, Engine}
import io.fernandobontorin.yellowworld.game.{FPS, provider}
import io.fernandobontorin.yellowworld.midia.audio.sound_board
import io.fernandobontorin.yellowworld.midia.images.cached

import java.awt.Dimension
import javax.swing.{JFrame, WindowConstants}

object Start {
  val engine: Engine   = new Engine()
  val display: Display = new Display(new Dimension(1200, 800))
  val threadEngine = new Thread(engine)
  val threadDisplay = new Thread(display)

  def main(args: Array[String]): Unit = {
    cached.init()

    val frame = new JFrame("Yellow World")
    frame.add(display)
    frame.setResizable(false)
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
    frame.pack()
    frame.setLocationRelativeTo(null)
    frame.setVisible(true)

    threadEngine.start()
    sound_board.theme()

    val game = provider.game
    val fps = new FPS(frame)
  }
}
