package org.mizzoucs3330team.assignment_03;

import javax.sound.midi.*;
//import javax.sound.midi.MidiEvent;

public class StaccatoMidiEventFactory implements MidiEventFactory {

	private PitchStrategy pitchStrategy;

	@Override
	public void setPitchStrategy(PitchStrategy strategy){
		this.pitchStrategy = strategy;
	}

	@Override
	public MidiEvent createNoteOn(int tick, int note, int channel) throws InvalidMidiDataException {
		int modifiedNote = (pitchStrategy != null) ? pitchStrategy.modifyPitch(note) : note;
		ShortMessage message = new ShortMessage();

		message.setMessage(message.NOTE_ON, channel, modifiedNote, 64);

		return new MidiEvent(message, tick);
	}

	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();

		message.setMessage(message.NOTE_ON, channel, note, velocity);
		
		return new MidiEvent(message, tick);
	}

	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		int modifiedNote = (pitchStrategy != null) ? pitchStrategy.modifyPitch(note) : note;
		ShortMessage message = new ShortMessage();

		message.setMessage(message.NOTE_OFF, channel, modifiedNote, 100);

		//-120 ticks for shorter
		return new MidiEvent(message, tick-120);
	}

}
