package org.mizzoucs3330team.assignment_03.pitchStrategies;

public class HigherPitchStrategy implements PitchStrategy {

	/**
	 * Raise a note's pitch by two semitones.
	 * 
	 * @param note The note to be modified.
	 * 
	 * @return Returns the raised note.
	 */
	@Override
	public int modifyPitch(int note) {
		return note + 2;
	}

}
