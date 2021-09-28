package io.fernandobontorin.yellowworld.midia.audio

import io.fernandobontorin.yellowworld.midia.tools.{assets, resources}

object sound_board {

  def theme(): Unit =
    new WavAudio(assets("musics/Rapture.wav")).start()

  def achievement(): Unit = new WavAudio(resources("sounds/ACHIEVEMENT.WAV")).start()

  def coin(): Unit = new WavAudio(assets("sounds/COIN.WAV")).start()

  def gameReady(): Unit = new WavAudio(assets("sounds/dota-2-game-ready-sound.wav")).start()

  def lose(): Unit = new WavAudio(assets("sounds/LOSE.WAV")).start()

}
