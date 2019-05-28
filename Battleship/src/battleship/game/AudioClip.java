/* 
 * Josh Tony Brayden
 * May 28, 2019
 * This class handles the audio  
 */
package battleship.game;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author toyu2550
 */
public class AudioClip {

    private Clip clip;

    public AudioClip(String sound) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }

    }
    public void play(){
        clip.start();
    }
    
    public void stop(){
        clip.stop();
    }
    public void loop(){
        clip.loop(1010);
    }

}
