package io.fernandobontorin.yellowworld.midia.audio

import io.fernandobontorin.yellowworld.core.engine.config

import java.io.{BufferedInputStream, InputStream}
import javax.sound.sampled.{AudioSystem, FloatControl}

class WavAudio(inputStream: InputStream) extends Thread {

  override def run(): Unit = {
    val audioInputStream =
      AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream))
    val clip = AudioSystem.getClip
    clip.open(audioInputStream)
    val floatControl = clip.getControl(FloatControl.Type.MASTER_GAIN).asInstanceOf[FloatControl]
    config.addFloatControl(floatControl)
    clip.start()
  }

}
