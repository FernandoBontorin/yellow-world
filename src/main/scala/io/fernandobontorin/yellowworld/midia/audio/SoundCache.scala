package io.fernandobontorin.yellowworld.midia.audio

import io.fernandobontorin.yellowworld.midia.ResourceCache
import io.fernandobontorin.yellowworld.midia.tools.{assets, resources}

import scala.collection.mutable

class SoundCache extends ResourceCache[Audio] {

  private val sounds: mutable.Map[String, WavAudio] = mutable.HashMap.empty

  {
    sounds.addOne("theme", new WavAudio(assets("musics/Rapture.wav")))
    sounds.addOne("achievement", new WavAudio(resources("sounds/ACHIEVEMENT.WAV")))
    sounds.addOne("coin", new WavAudio(assets("sounds/COIN.WAV")))
    sounds.addOne("gameReady", new WavAudio(assets("sounds/dota-2-game-ready-sound.wav")))
    sounds.addOne("lose", new WavAudio(assets("sounds/LOSE.WAV")))
  }

  override def query(s: String): Audio =
    sounds.getOrElse(s, throw new NoSuchElementException(s"not found any sound:$s"))
}
