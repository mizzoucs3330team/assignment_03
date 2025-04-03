package org.mizzoucs3330team.assignment_03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MidiCsvParser {

    public static List<MidiEventData> parseCsv(String filePath){

        //create list for midiEvents
        List<MidiEventData> midiEvents = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            
            //create line and read it
            String line;
            while ((line = br.readLine()) != null){
                
                //identify each value separated by commas
                String[] values = line.split(",");

                //reject if too little or too many values (excludable)
                if (values.length != 6){
                    System.out.println("Invalid Line: " + line);
                    continue;
                }

                try{
                    //assign vars for event from line read 
                    int startEndTick = Integer.parseInt(values[0].trim());
                    int velocity  = Integer.parseInt(values[1].trim());
                    int note = Integer.parseInt(values[2].trim());
                    int channel = Integer.parseInt(values[3].trim());
                    int instrument = Integer.parseInt(values[4].trim());
                    int noteOnOff = Integer.parseInt(values[5].trim());

                    //create event
                    MidiEventData event = new MidiEventData(startEndTick, velocity, note, channel, instrument, noteOnOff);
                    
                    //add event to list
                    midiEvents.add(event);
                }
                catch (NumberFormatException e){
                    System.out.println("Invalid number format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //return value
        return midiEvents;
    }

}