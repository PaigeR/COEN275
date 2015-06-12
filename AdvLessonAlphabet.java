import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;

import javax.swing.*;

import javazoom.jl.decoder.JavaLayerException;

import com.gtranslate.Audio;
import com.gtranslate.Language;

class AdvLessonAlphabet extends JPanel {
	static JPanel aPanel;
	static String username;
	
	 public AdvLessonAlphabet() {
		 aPanel = this;
	 }
	 
	 public static void init(String name){
		 username = name;
         /*JFrame frame = new JFrame();
         frame.getContentPane().add(aPanel);
*/			
	        aPanel.setSize(990,750);


	        aPanel.setFocusable(true);
            aPanel.requestFocusInWindow();

            /*frame.setSize(990,750);
            frame.setVisible(true);	    
*/
	        Audio audio = Audio.getInstance();
			InputStream sound1 = null;
			try {
				sound1 = audio.getAudio("This is Advanced Alphabet Lesson. Press any key to Learn the alphabet.", Language.ENGLISH);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			audio.play(sound1);
		} catch (JavaLayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
	
	aPanel.addKeyListener(new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {
        	char c=e.getKeyChar();
	        System.out.println("keyTyped: "+e.getKeyChar());
	        Audio audio = Audio.getInstance();
			InputStream sound = null;
			try {
					sound = audio.getAudio(" "+ c, Language.ENGLISH);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				audio.play(sound);
			} catch (JavaLayerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }

        @Override
        public void keyReleased(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("Pressed " + e.getKeyChar());
        }
    });
	Timer timer = new Timer();
	timer.schedule(new TimerTask() {

	        @Override
	        public void run() {
	            Platform.runLater(new Runnable() {
	                @Override
	                public void run() {
	                	//code to transition to Adv counting lesson
	                	Welcome.showAdvGameAlphabet();
	                	AdvGameAlphabet.init(username);
	   
	                	}
	            });

	        }
	    }, 10000);	

}
	    
}