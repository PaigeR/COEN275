import java.awt.Dimension;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javax.swing.*;
import javazoom.jl.decoder.JavaLayerException;
import com.gtranslate.Audio;
import com.gtranslate.Language;

public class AdvGameAlphabet extends JPanel {
		private char input;//stores the input entered by the user
		private char answer; //Stores the right answer
		static JFXPanel panel;
		static JFrame frame;
		
		public void interval(){
			Audio audio = Audio.getInstance();
	    	InputStream sound1 = null;
	    	try {
				sound1 = audio.getAudio("To answer. Press the correct alphabet on the keyboard.", Language.ENGLISH);
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
			try {
				   Thread.sleep(4000);
			   
				} catch (InterruptedException ie) {
				}
			
		 }
 public void question(char ans){
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
	panel.setScene(scene);
	
	
 }

public static void main(String[] args) {
	panel = new JFXPanel();
    frame = new JFrame("Adv Alphabet Game");
    frame.getContentPane().add(panel);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    AdvGameAlphabet q1 = new AdvGameAlphabet();
    q1.question('a');
    q1.interval();
    AdvGameAlphabet q2 = new AdvGameAlphabet();
    q2.question('f');
    q2.interval();
    //AdvGameAlphabet q3 = new AdvGameAlphabet('m');
    //AdvGameAlphabet q4 = new AdvGameAlphabet('l');
    //AdvGameAlphabet q5 = new AdvGameAlphabet('p');
    panel.setFocusable(true);
    panel.requestFocusInWindow();

    frame.setSize(new Dimension(990,750));
    frame.setVisible(true);
}
}