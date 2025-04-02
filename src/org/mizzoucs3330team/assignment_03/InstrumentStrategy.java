package org.mizzoucs3330team.assignment_03;

import javax.sound.midi.Track;

public interface InstrumentStrategy {

	// TODO: Fill this out.
	/**
	 * 
	 * @param track
	 * @param channel
	 */
	void applyInstrument(Track track, int channel);

}
