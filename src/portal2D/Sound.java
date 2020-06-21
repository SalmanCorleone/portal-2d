package portal2D;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	public static AudioInputStream in;
	public static Clip menuBg;
	public static Sequence yo;
	public static Sequencer xo;
	
	public static Clip portal;
	public static Clip jump;
	
	
	public Sound()
	{
		try {
			yo=MidiSystem.getSequence(new File("./Sounds/Trooop.MID"));
			xo= MidiSystem.getSequencer();
			xo.open();
			xo.setSequence(yo);
			
			
			in= AudioSystem.getAudioInputStream(new File("./Sounds/bg.WaV"));
			menuBg= AudioSystem.getClip();
			menuBg.open(in);
			
			in= AudioSystem.getAudioInputStream(new File("./Sounds/mam.WaV"));
			portal= AudioSystem.getClip();
			portal.open(in);
			
//			in= AudioSystem.getAudioInputStream(new File("./Sounds/bg.WaV"));
//			portal= AudioSystem.getClip();
//			portal.open(in);
//			
			
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static synchronized void play()
	{
		new Thread(new Runnable(){

			public void run() {
				xo.setLoopCount(5);
				
			}
			
		}).start();
		
	}

}
