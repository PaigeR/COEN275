import java.awt.Dimension;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;

import javax.swing.*;

import javazoom.jl.decoder.JavaLayerException;

import com.gtranslate.Audio;
import com.gtranslate.Language;

public class AdvGameAlphabet extends JFXPanel {
		private static char input;//stores the input entered by the user
		private static char answer; //Stores the right answer
		static JFXPanel panel;
		
		public AdvGameAlphabet(){
			panel= this;
		}
		public static void interval(){
			Audio audio = Audio.getInstance();
	    	InputStream sound1 = null;
	    	try {
				sound1 = audio.getAudio("This is Advanced Alphabet Game. To answer. Press the correct alphabet on the keyboard. Press A on the keyboard", Language.ENGLISH);
				try {
					audio.play(sound1);
				} catch (JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
		 }
public static void init(){
	interval();
	question('a');
			
		}
 public static void question(char ans){
	 answer=ans;
	 Group root = new Group();
	Scene scene = new Scene(root, 540, 210);
	   
	panel.addKeyListener(new KeyListener() {
		public void keyTyped(KeyEvent e) {
	    	input=e.getKeyChar();
	        System.out.println("keyTyped: "+e.getKeyChar());
	        Audio audio = Audio.getInstance();
			InputStream sound = null;

					
				System.out.println("MY input: "+ input);
				System.out.println("Answer: "+ answer);
					if(input == answer){
						input='\0';
					try {
						sound = audio.getAudio("RIGHT ANSWER CONGRATULATIONS", Language.ENGLISH);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						audio.play(sound);
					} catch (JavaLayerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
					else{
						try {
							sound = audio.getAudio("Sorry. Wrong Answer", Language.ENGLISH);
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
					
					
					
			}
	    public void keyPressed(KeyEvent e) {
	    }
	    public void keyReleased(KeyEvent e) {
	    }
	    
	   });
	((Group)scene.getRoot()).getChildren();
	 panel.setFocusable(true);
	 panel.requestFocusInWindow();

	panel.setScene(scene);
	Timer timer = new Timer();
	timer.schedule(new TimerTask() {

	        @Override
	        public void run() {
	            Platform.runLater(new Runnable() {
	                @Override
	                public void run() {
	                	Welcome.showAdvLessonCounting();
	                	AdvCountingLesson.start();
	                }
	            });

	        }
	    }, 10000);	
	
	
 }
}