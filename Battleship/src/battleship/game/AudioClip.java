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

    /**
     * This constructor is used for the file path
     * @param sound - the file path of the audio clip
     */
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
    
    //This method plays the audio clip
    public void play(){
        clip.start();
    }
    
    //This method stops the audio clip
    public void stop(){
        clip.stop();
    }
    
    //This method repeats the audio clip
    public void loop(){
        clip.loop(1010);
    }

}
