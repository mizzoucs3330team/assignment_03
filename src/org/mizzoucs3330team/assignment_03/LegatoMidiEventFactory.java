package org.mizzoucs3330team.assignment_03;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.*;

public class LegatoMidiEventFactory implements MidiEventFactory {

    private PitchStrategy pitchStrategy;

    @Override
    public void setPitchStrategy(PitchStrategy strategy) {
        this.pitchStrategy = strategy;
    }

    @Override
    public MidiEvent createNoteOn(int tick, int note, int channel) throws InvalidMidiDataException {
        int modifiedNote = (pitchStrategy != null) ? pitchStrategy.modifyPitch(note) : note;
        ShortMessage message = new ShortMessage();
        
		message.setMessage(ShortMessage.NOTE_ON, channel, modifiedNote, 100);
        
		return new MidiEvent(message, tick);
    }

    @Override
    public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
        int modifiedNote = (pitchStrategy != null) ? pitchStrategy.modifyPitch(note) : note;
        ShortMessage message = new ShortMessage();
        
		message.setMessage(ShortMessage.NOTE_OFF, channel, modifiedNote, 100);
        
		//+80 ticks for transition
        return new MidiEvent(message, tick + 80);
    }
}
