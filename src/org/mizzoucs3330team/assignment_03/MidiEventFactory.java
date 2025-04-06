package org.mizzoucs3330team.assignment_03;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

public interface MidiEventFactory {

	/**
	 * Create a NoteOn MidiEvent.
	 * 
	 * @param tick     The tick the note begins at.
	 * @param note     The pitch of the note.
	 * @param velocity The velocity of the note.
	 * @param channel  The channel to be played on.
	 * 
	 * @return Returns the MidiEvent.
	 * @throws InvalidMidiDataException
	 */
	MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;

	/**
	 * Create a NoteOff MidiEvent.
	 * 
	 * @param tick    The tick the note stops at.
	 * @param note    The pitch of the note.
	 * @param channel The channel of the note.
	 * 
	 * @return Returns the MidiEvent.
	 * @throws InvalidMidiDataException
	 */
	MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;

}
