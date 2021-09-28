package io.fernandobontorin.yellowworld.core.engine

import javax.sound.sampled.FloatControl
import scala.collection.mutable

object config {

  val floatControls: mutable.HashSet[FloatControl] = mutable.HashSet.empty
  var lastDecibelsChange: Float                    = 0

  def addFloatControl(fc: FloatControl): Unit =
    floatControls.add(fc)

  def removeFloatControl(fc: FloatControl): Unit =
    floatControls.remove(fc)

  def decreaseDecibels(): Unit = {
    lastDecibelsChange = -5
    update()
  }

  def update(): Unit = {
    floatControls.foreach(
      control => {
        try {
          control.shift(control.getValue, control.getValue + lastDecibelsChange, 0)
        }
        catch {
          case x: IllegalArgumentException => println(x.getMessage)
        }
      })
    lastDecibelsChange = 0
  }

  def increaseDecibels(): Unit = {
    lastDecibelsChange = 5
    update()
  }

}
