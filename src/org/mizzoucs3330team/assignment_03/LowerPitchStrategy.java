package org.mizzoucs3330team.assignment_03;

public class LowerPitchStrategy implements PitchStrategy {

	/**
	 * Lower a note's pitch by two semitones.
	 */
	@Override
	public int modifyPitch(int note) {
		return note - 2;
	}

}
