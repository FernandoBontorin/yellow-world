package io.fernandobontorin.yellowworld.elements.entities

import io.fernandobontorin.yellowworld.elements.Element
import io.fernandobontorin.yellowworld.elements.animations.ScoreChange

import java.awt.{Color, Font, Graphics, Point}
import scala.collection.mutable

class ScoreBoard extends Element {
  private var score: Double = 0
  private val transactions: mutable.Queue[Double] = mutable.Queue.empty
  val font = new Font(Font.SANS_SERIF, Font.PLAIN, 24)

  def currentScore: Double = score

  override def tick(): Unit = {
    if(transactions.nonEmpty){
      val amount = transactions.dequeueAll(_ => true).sum
      score += amount
      new ScoreChange(amount)
    }
  }

  override def draw(graphics: Graphics): Unit = {
    graphics.setColor(Color.orange)
    graphics.setFont(font)
    graphics.drawString(f"Yellow cores: $score",       500 - 128,
      300 - 64)
  }

  def enqueueTransaction(amount: Double):Unit = {
    transactions.enqueue(amount)
  }

  override def isIn(point: Point): Boolean = false

  override def click(point: Point): Unit = ???
}
