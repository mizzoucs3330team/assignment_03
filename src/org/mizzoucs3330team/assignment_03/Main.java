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

			// Parse MIDI CSV file
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("./mystery_song.csv");
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			Track track = sequence.createTrack();

			final MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
//			final MidiEventFactoryAbstract factoryAbstract = new LegatoMidiEventFactoryAbstract();
//			final MidiEventFactoryAbstract factoryAbstract = new StaccatoMidiEventFactoryAbstract();

			MidiEventFactory factory = factoryAbstract.createFactory();

			final InstrumentStrategy electricBassGuitarStrategy = new ElectricBassGuitarStrategy();
			final InstrumentStrategy trumpetStrategy = new TrumpetStrategy();
//			final InstrumentStrategy acousticGrandPianoStrategy = new AcousticGrandPianoStrategy();
			electricBassGuitarStrategy.applyInstrument(track, 0);
			trumpetStrategy.applyInstrument(track, 1);

			PitchStrategy pitchStrategy = new HigherPitchStrategy();
			// PitchStrategy pitchStrategy = new LowerPitchStrategy();

			for (MidiEventData event : midiEvents) {
				final int modifiedNote = pitchStrategy.modifyPitch(event.getNote());

				if (event.getNoteOnOff() == ShortMessage.NOTE_ON) {
					track.add(factory.createNoteOn(event.getStartEndTick(), modifiedNote, event.getVelocity(),
							event.getChannel()));
				} else {
					track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));
				}
			}

			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			sequencer.start();

			// Let the sequencer play.
			while (sequencer.isRunning()) {
				System.out.println("Sequencer is running...");
				Thread.sleep(100);
			}
			System.out.println("Sequencer is finished.");
			Thread.sleep(500);
			sequencer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
