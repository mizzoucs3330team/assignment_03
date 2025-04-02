package org.mizzoucs3330team.assignment_03;

public class HigherPitchStratgey implements PitchStrategy {

	/**
	 * Raise a note's pitch by two semitones.
	 */
	@Override
	public int modifyPitch(int note) {
		return note + 2;
	}

}
