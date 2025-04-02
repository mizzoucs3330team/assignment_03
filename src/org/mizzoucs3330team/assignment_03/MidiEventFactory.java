package org.mizzoucs3330team.assignment_03;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

public interface MidiEventFactory {

	// TODO: Fill out this JavaDoc.
	/**
	 * 
	 * @param tick
	 * @param note
	 * @param channel
	 * @return
	 * @throws InvalidMidiDataException
	 */
	MidiEvent createNoteOn(int tick, int note, int channel) throws InvalidMidiDataException;

	// TODO: Fill out this JavaDoc.
	/**
	 * 
	 * @param tick
	 * @param note
	 * @param channel
	 * @return
	 * @throws InvalidMidiDataException
	 */
	MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;

}
