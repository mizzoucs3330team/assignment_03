package org.mizzoucs3330team.assignment_03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.ShortMessage;

public class MidiCsvParser {

	/**
	 * Parse CSV text data into listed values.
	 * 
	 * @param filePath The path of the file.
	 * @return midiEvents List of MidiEventData
	 */
	public static List<MidiEventData> parseCsv(String filePath) {

		// create list for midiEvents
		List<MidiEventData> midiEvents = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.trim().replaceAll(" ", "").split(",");

				if (values.length != 6) {
					System.out.println("Invalid Line -- Too Many Values: " + line);
					continue;
				}

				try {
					// assign vars for event from line read
					int startEndTick = Integer.parseInt(values[0]);
					int noteOnOff = values[1].equals("Note_on_c") ? ShortMessage.NOTE_ON : ShortMessage.NOTE_OFF;
					int channel = Integer.parseInt(values[2]);
					int note = Integer.parseInt(values[3]);
					int velocity = Integer.parseInt(values[4]);
					int instrument = Integer.parseInt(values[5]);

					// create event
					MidiEventData event = new MidiEventData(startEndTick, velocity, note, channel, instrument,
							noteOnOff);

					// add event to list
					midiEvents.add(event);
				} catch (NumberFormatException e) {
					System.out.println("Invalid number format: " + line);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// return value
		return midiEvents;
	}

}