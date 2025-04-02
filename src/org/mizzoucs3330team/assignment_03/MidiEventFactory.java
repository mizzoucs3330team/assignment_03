package org.mizzoucs3330team.assignment_03;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

public interface MidiEventFactory {

	MidiEvent createNoteOn(int tick, int note, int channel) throws InvalidMidiDataException;

	MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;

}
