package io.fernandobontorin.yellowworld.midia.audio

import java.io.{BufferedInputStream, InputStream}
import javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED
import javax.sound.sampled.AudioSystem.getAudioInputStream
import javax.sound.sampled.{AudioFormat, AudioInputStream, AudioSystem, DataLine, SourceDataLine}

class Mp3Audio(inputStream: InputStream) extends Audio {

  override def run(): Unit = {
    val audioInputStream =
      AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream))

    val format = getOutFormat(audioInputStream.getFormat)
    val info = new DataLine.Info(classOf[SourceDataLine], format)
    val line = AudioSystem.getLine(info).asInstanceOf[SourceDataLine]
    if (line != null) {
      line.open(format)
      line.start()
      stream(getAudioInputStream(format, audioInputStream), line)
      line.drain()
      line.stop()
    }
  }

  private def getOutFormat(inFormat: AudioFormat) = {
    val ch   = inFormat.getChannels
    val rate = inFormat.getSampleRate
    new AudioFormat(PCM_SIGNED, rate, 16, ch, ch * 2, rate, false)
  }

  private def stream(in: AudioInputStream, line: SourceDataLine): Unit = {
    val buffer = new Array[Byte](4096)
    var n = 0
    while ( {
      n != -1
    }) {
      line.write(buffer, 0, n)

      n = in.read(buffer, 0, buffer.length)
    }
  }
}
