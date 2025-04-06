package org.mizzoucs3330team.assignment_03;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class StandardMidiEventFactory implements MidiEventFactory {

	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		final ShortMessage msg = new ShortMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		return new MidiEvent(msg, tick);
	}

	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		final ShortMessage msg = new ShortMessage(ShortMessage.NOTE_OFF, channel, note, 100);
		return new MidiEvent(msg, tick);
	}

}
