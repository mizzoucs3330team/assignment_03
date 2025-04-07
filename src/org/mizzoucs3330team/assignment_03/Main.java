package org.mizzoucs3330team.assignment_03;

import java.util.List;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import org.mizzoucs3330team.assignment_03.instrumentStrategies.AcousticGrandPianoStrategy;
import org.mizzoucs3330team.assignment_03.instrumentStrategies.ElectricBassGuitarStrategy;
import org.mizzoucs3330team.assignment_03.instrumentStrategies.InstrumentStrategy;
import org.mizzoucs3330team.assignment_03.instrumentStrategies.TrumpetStrategy;
import org.mizzoucs3330team.assignment_03.pitchStrategies.HigherPitchStrategy;
import org.mizzoucs3330team.assignment_03.pitchStrategies.PitchStrategy;

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

//			final MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
//			final MidiEventFactoryAbstract factoryAbstract = new LegatoMidiEventFactoryAbstract();
			final MidiEventFactoryAbstract factoryAbstract = new StaccatoMidiEventFactoryAbstract();

			MidiEventFactory factory = factoryAbstract.createFactory();

			final InstrumentStrategy electricBassGuitarStrategy = new ElectricBassGuitarStrategy();
			final InstrumentStrategy trumpetStrategy = new TrumpetStrategy();
			final InstrumentStrategy acousticGrandPianoStrategy = new AcousticGrandPianoStrategy();
			electricBassGuitarStrategy.applyInstrument(track, 0);
//			acousticGrandPianoStrategy.applyInstrument(track, 2);
//			acousticGrandPianoStrategy.applyInstrument(track, 3);
//			acousticGrandPianoStrategy.applyInstrument(track, 4);

			PitchStrategy pitchStrategy = new HigherPitchStrategy();
//			PitchStrategy pitchStrategy = new LowerPitchStrategy();

			for (MidiEventData event : midiEvents) {
//				final int note = event.getNote();
				final int note = pitchStrategy.modifyPitch(event.getNote());

				if (event.getNoteOnOff() == ShortMessage.NOTE_ON) {
					track.add(factory.createNoteOn(event.getStartEndTick(), note, event.getVelocity(),
							event.getChannel()));
				} else {
					track.add(factory.createNoteOff(event.getStartEndTick(), note, event.getChannel()));
				}
			}

			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			sequencer.start();

			// Let the sequencer play.
			while (sequencer.isRunning()) {
				System.out.print("Sequencer is running");
				Thread.sleep(1000);
				System.out.print(".");
				Thread.sleep(1000);
				System.out.print(".");
				Thread.sleep(1000);
				System.out.print(".");
				System.out.println();
			}
			System.out.println("Sequencer is finished.");
			Thread.sleep(500);
			sequencer.close();

			System.out.println();
			System.out.println("The song was \"bad guy\" by Billie Eilish.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
