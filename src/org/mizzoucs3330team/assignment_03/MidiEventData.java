package org.mizzoucs3330team.assignment_03;

public class MidiEventData {
	private int startEndTick;
	private int velocity;
	private int note;
	private int channel;
	private int noteOnOff;
	private int instrument;

	// TODO: This may need a JavaDoc comment.
	public MidiEventData(int s, int v, int n, int c, int i, int nOO) {
		this.startEndTick = s;
		this.velocity = v;
		this.note = n;
		this.channel = c;
		this.instrument = i;
		this.noteOnOff = nOO;
	}

	// Getters
	public int getStartEndTick() {return startEndTick;}
	public int getVelocity() {return velocity;}
	public int getNote() {return note;}
	public int getChannel() {return channel;}
	public int getInstrument() {return instrument;}
	public int getNoteOnOff() {return noteOnOff;}

	//Setters
    public void setStartEndTick(int startEndTick) {this.startEndTick = startEndTick;}
    public void setVelocity(int velocity) {this.velocity = velocity;}
    public void setNote(int note) {this.note = note;}
    public void setChannel(int channel) {this.channel = channel;}
    public void setInstrument(int instrument) {this.instrument = instrument;}
    public void setNoteOnOff(int noteOnOff) {this.noteOnOff = noteOnOff;}

	
    @Override
    public String toString() {
        return  "MidiEventData: startEndTick= " + startEndTick +
                ", velocity= " + velocity +
                ", note= " + note +
                ", channel= " + channel +
                ", instrument= " + instrument +
                ", noteOnOff= " + noteOnOff +
                '}';
    }
}
