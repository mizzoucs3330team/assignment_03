package org.mizzoucs3330team.assignment_03;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class LegatoMidiEventFactory extends StandardMidiEventFactory {

	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage msg = new ShortMessage(ShortMessage.NOTE_OFF, channel, note, 100);

		// IMPORTANT: +80 ticks for transition
		return new MidiEvent(msg, tick + 80);
	}

}
