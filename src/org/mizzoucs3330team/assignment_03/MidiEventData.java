package org.mizzoucs3330team.assignment_03;

public class MidiEventData {
	private int startEndTick;
	private int velocity;
	private int note;
	private int channel;
	private int noteOnOff;
	private int instrument;

	public MidiEventData(int s, int v, int n, int c, int i, int nOO) {
		this.startEndTick = s;
		this.velocity = v;
		this.note = n;
		this.channel = c;
		this.instrument = i;
		this.noteOnOff = nOO;
	}

	// TODO: Implement the getters/setters.
}
