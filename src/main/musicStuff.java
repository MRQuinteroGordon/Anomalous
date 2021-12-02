package main;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class musicStuff {
	
	void playMusic (String musicLocation) {
		System.out.println("Hello");
		try {
			System.out.println("Hello2");
			File musicPath = new File(musicLocation);
			if(musicPath.exists()) {
				System.out.println("Hello3");
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				System.out.println("Hello4");
				clip.start();
//				clip.loop(Clip.LOOP_CONTINUOUSLY);
//				System.out.println("Hello5");
				JOptionPane.showMessageDialog(null, "Signing in... ");
				System.out.println("Hello6");
				clip.stop();
			}
			else {
				System.out.println("can't find file");
			}
		}
		catch (Exception f){
			f.printStackTrace();
		}
	}
	
	
}
