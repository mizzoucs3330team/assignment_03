package org.mizzoucs3330team.assignment_03.instrumentStrategies;

import javax.sound.midi.Track;

public interface InstrumentStrategy {

	/**
	 * Apply an instrument to a channel.
	 * 
	 * @param track   The track.
	 * @param channel The channel to apply the instrument to.
	 */
	void applyInstrument(Track track, int channel);

}
