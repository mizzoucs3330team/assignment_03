package org.mizzoucs3330team.assignment_03;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class StandardMidiEventFactory implements MidiEventFactory {

	private PitchStrategy pitchStrategy;

	@Override
	public void setPitchStrategy(PitchStrategy strategy){
		this.pitchStrategy = strategy;
	}

	@Override
	public MidiEvent createNoteOn(int tick, int note, int channel) throws InvalidMidiDataException {
		int modifiedNote = (pitchStrategy != null) ? pitchStrategy.modifyPitch(note) : note;
		ShortMessage message = new ShortMessage();

		message.setMessage(message.NOTE_ON, channel, modifiedNote, 100);

		return new MidiEvent(message, tick);
	}

	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		int modifiedNote = (pitchStrategy != null) ? pitchStrategy.modifyPitch(note) : note;
		ShortMessage message = new ShortMessage();

		message.setMessage(message.NOTE_OFF, channel, modifiedNote, 100);

		//no change
		return new MidiEvent(message, tick);
	}

}
