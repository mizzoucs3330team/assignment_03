package org.mizzoucs3330team.assignment_03;

import javax.imageio.ImageIO;
import javax.sound.midi.*;

public class Main {

	/**
	 * The entry point for the application.
	 * 
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		//choose facotry type
		MidiEventFactory factory = MidiEventFactory.getFactory("staccato");
		//MidiEventFactory factory = MidiEventFactory.getFactory("legato");
		//MidiEventFactory factory = MidiEventFactory.getFactory("standard");

		//Set a pitch strat
		factory.setPitchStrategy(new HigherPitchStratgey());

		//declare example vars
		int tick = 0;
		int note = 60;
		int channel = 0;

		MidiEvent noteOn = null;
		MidiEvent noteOff = null;

		//create noteOn & noteOff
		try {
			noteOn = factory.createNoteOn(tick, note, channel);
		}
		catch (InvalidMidiDataException e){
			e.printStackTrace();
		}
			
		try {
			noteOff = factory.createNoteOff(tick, note, channel);
		}
		catch (InvalidMidiDataException e){
			e.printStackTrace();
		}
		
		//if try statements pass
		if (noteOn != null && noteOff != null) {
			System.out.println("Note ON Tick: " + noteOn.getTick());
			System.out.println("Note OFF Tick: " + noteOff.getTick());
		}
	}
}
