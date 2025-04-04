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
	MidiEvent createNoteOn(int tick, int note, int channel, int velocity) throws InvalidMidiDataException;

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

	void setPitchStrategy(PitchStrategy strategy);

	/**
	 * getFactory
	 * called to specify factory type based on Str parameter 'type'
	 * @param type
	 * @return Appropriate factory declaration
	 * 
	 * Create factory in main with:
	 * MidiEventFactory factory = MidiEventFactory.getFactory("type")
	 * then assign noteOn and noteOff
	 */
	static MidiEventFactory getFactory(String type){
		switch(type.toLowerCase()){
			case "staccato":
				return new StaccatoMidiEventFactory();
			case "legato":
				return new LegatoMidiEventFactory();
			case "standard":
				return new StandardMidiEventFactory();
			default:
				return new StandardMidiEventFactory();
		}
	}
}
