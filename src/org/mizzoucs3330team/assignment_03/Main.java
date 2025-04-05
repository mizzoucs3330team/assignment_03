package org.mizzoucs3330team.assignment_03;

import java.util.List;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class Main {

	/**
	 * The entry point for the application.
	 * 
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		try {

			// parse MIDI CSV file
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("./???/mystery_song.csv");

			// create a sequence with resolution 384 ticks per quarter note
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			Track track = sequence.createTrack();

			// choose Midi Event Factory type
			MidiEventFactory factory = MidiEventFactory.getFactory("staccato");
			// MidiEventFactory factory = MidiEventFactory.getFactory("legato");
			// MidiEventFactory factory = MidiEventFactory.getFactory("standard");

			// apply instrument strat
			// TODO

			// set pitch strat
			factory.setPitchStrategy(new HigherPitchStratgey());

			for (MidiEventData event : midiEvents) {

				// TODO -- part of instrument strategy I believe
				int modifiedNote = factory.getPitchStrategy().modifyPitch(event.getNote());
				modifiedNote = factory.getPitchStrategy().modifyPitch(modifiedNote); // apply again if you want

				if (event.getNoteOnOff() == ShortMessage.NOTE_ON) {
					track.add(factory.createNoteOn(event.getStartEndTick(), modifiedNote, event.getVelocity(),
							event.getChannel()));
				} else {
					track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));
				}
			}

			// set up and start the sequencer
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			sequencer.start();

			// let it play
			while (sequencer.isRunning() || sequencer.isOpen()) {
				Thread.sleep(100);
			}

			Thread.sleep(500);
			sequencer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
