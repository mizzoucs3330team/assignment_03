package org.mizzoucs3330team.assignment_03;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class AcousticGrandPianoStrategy implements InstrumentStrategy {

	@Override
	public void applyInstrument(Track track, int channel) {
		try {
			final int NUM = 0;
			ShortMessage msg = new ShortMessage(ShortMessage.PROGRAM_CHANGE, channel, NUM, 0);
			track.add(new MidiEvent(msg, 0));
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
