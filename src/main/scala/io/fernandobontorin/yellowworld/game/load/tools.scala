package io.fernandobontorin.yellowworld.game.load

import io.fernandobontorin.yellowworld.Main
import io.fernandobontorin.yellowworld.game.load.model.ToolModel

object tools {

  def firstTool(): ToolModel = ToolModel(0, "Oracle", Main.resourceManager.getImageProvider("heroes/oracle-icon"))

}
