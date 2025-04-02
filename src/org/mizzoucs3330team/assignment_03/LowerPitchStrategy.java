package org.mizzoucs3330team.assignment_03;

public class LowerPitchStrategy implements PitchStrategy {

	@Override
	public int modifyPitch(int note) {
		// TODO Auto-generated method stub
		return note - 2;
	}

}
