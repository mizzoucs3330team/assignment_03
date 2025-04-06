package org.mizzoucs3330team.assignment_03.instrumentStrategies;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class TrumpetStrategy implements InstrumentStrategy {

	@Override
	public void applyInstrument(Track track, int channel) {
		try {
			final int NUM = 56;
			ShortMessage msg = new ShortMessage(ShortMessage.PROGRAM_CHANGE, channel, NUM, 0);
			track.add(new MidiEvent(msg, 0));
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}

}
