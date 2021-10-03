package io.fernandobontorin.yellowworld

import io.fernandobontorin.yellowworld.core.{Display, Engine}
import io.fernandobontorin.yellowworld.elements.ElementManager
import io.fernandobontorin.yellowworld.game.{FPS, Game}
import io.fernandobontorin.yellowworld.midia.driver.ResourceManager

import java.awt.Dimension
import javax.swing.{JFrame, WindowConstants}

object Main {
  val resourceManager  = new ResourceManager()
  val elementManager   = new ElementManager()
  val engine: Engine   = new Engine()
  val display: Display = new Display(new Dimension(1200, 800))
  val threadEngine     = new Thread(engine)
  val threadDisplay    = new Thread(display)
  val game             = new Game()

  def main(args: Array[String]): Unit = {
    val frame = new JFrame("Yellow World")
    frame.add(display)
    frame.setResizable(false)
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
    frame.pack()
    frame.setLocationRelativeTo(null)
    frame.setVisible(true)

    threadEngine.start()
    resourceManager.playSound("default-main-01")

    val fps = new FPS(frame)
  }
}
