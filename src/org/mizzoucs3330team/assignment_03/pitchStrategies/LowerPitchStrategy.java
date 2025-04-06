package org.mizzoucs3330team.assignment_03.pitchStrategies;

public class LowerPitchStrategy implements PitchStrategy {

	/**
	 * Lower a note's pitch by two semitones.
	 * 
	 * @param The note to be modified.
	 * 
	 * @return Returns the lowered note.
	 */
	@Override
	public int modifyPitch(int note) {
		return note - 2;
	}

}
