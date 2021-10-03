package io.fernandobontorin.yellowworld.midia.audio

import java.io.InputStream
import javax.sound.midi.{MidiSystem, Sequence, Sequencer}

class MidiAudio(inputStream: InputStream) extends Audio {
  val sequencer: Sequencer = MidiSystem.getSequencer

  override def run(): Unit = {
    sequencer.open()
    sequencer.setSequence(MidiSystem.getSequence(inputStream))
    sequencer.setLoopCount(0)
    sequencer.start()
  }

}
