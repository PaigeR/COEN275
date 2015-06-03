//Class to play the advanced counting game
//Ask question and input number

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.swing.*;

import javazoom.jl.decoder.JavaLayerException;

import com.gtranslate.Audio;
import com.gtranslate.Language;

public class AdvCountingGame extends JFrame{

	public static JFrame frame = new JFrame("Advanced Counting Game");
	boolean flag=true; //to keep track to only take one response per question 
	static int advCountingGameScore = 0;
	
public void questionOne(){
		flag=true;
		final JFXPanel fxPanel = new JFXPanel();
		frame.add(fxPanel);
		
		final File f1 = new File("C:/Users/proga_000/Videos/catmeow1.mp4");
		
		Group root = new Group();
		Scene scene = new Scene(root, 540, 210);
		
		Media media = new Media(f1.toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		((Group)scene.getRoot()).getChildren().add(mediaView);
		fxPanel.setScene(scene);

		
		Audio audio = Audio.getInstance();
		InputStream sound = null;
		try {
			Thread.sleep(5000);
			sound = audio.getAudio("How many times did the cat meow?", Language.ENGLISH);
		} catch (IOException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			audio.play(sound);
		} catch (JavaLayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		frame.addKeyListener(new KeyTyped()
		{
			Audio audio = Audio.getInstance();
	    	InputStream sound = null;
			public void keyTyped(KeyEvent e){
				System.out.println("keyTyped: "+e.getKeyChar());
				char c=e.getKeyChar();
				if(flag == true){ 
					
					if(c=='1'){
						try {
							sound = audio.getAudio("Correct Answer!", Language.ENGLISH);
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
		        	
						advCountingGameScore++;
					}
					else {
						try {
							sound = audio.getAudio("I'm sorry... that's the wrong answer", Language.ENGLISH);
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
					flag=false;
					return;
				}
			}
		});
				
		try {
			   Thread.sleep(3000);
			   frame.remove(fxPanel);
		   
		} catch (InterruptedException ie) {
		}
	
}
	
public void questionTwo(){
	final JFXPanel fxPanel2 = new JFXPanel();
	frame.add(fxPanel2);
	
	final File f2 = new File("C:/Users/proga_000/Videos/sheepbaa3.mp4");
	
	Group root = new Group();
	root.getChildren().clear();
	Scene scene = new Scene(root, 540, 210);

	Media media = new Media(f2.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	mediaPlayer.setAutoPlay(true);
	MediaView mediaView2 = new MediaView(mediaPlayer);
	((Group)scene.getRoot()).getChildren().add(mediaView2);
	fxPanel2.setScene(scene);
	
	
	Audio audio = Audio.getInstance();
	InputStream sound = null;
	try {
		Thread.sleep(5000);
		sound = audio.getAudio("How many times did the sheep baa?", Language.ENGLISH);
	} catch (IOException | InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		audio.play(sound);
	} catch (JavaLayerException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	frame.addKeyListener(new KeyTyped()
	{
		Audio audio = Audio.getInstance();
    	InputStream sound = null;
		public void keyTyped(KeyEvent e){
			System.out.println("keyTyped: "+e.getKeyChar());
			char c=e.getKeyChar();
			if(flag == true){
				if(c=='3'){
					try {
						sound = audio.getAudio("Correct Answer!", Language.ENGLISH);
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
	        	
					advCountingGameScore++;
				}
				else {
					try {
						sound = audio.getAudio("I'm sorry... that's the wrong answer", Language.ENGLISH);
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
				flag=false;
				return;
			}
		}
	});
	
	
	try {
		   Thread.sleep(3000);
		   frame.remove(fxPanel2);
	   
	} catch (InterruptedException ie) {
	}
	
}

public void questionThree(){
	final JFXPanel fxPanel3 = new JFXPanel();
	frame.add(fxPanel3);
	
	final File f3 = new File("C:/Users/proga_000/Videos/cowMoo2.mp4");
	
	Group root = new Group();
	root.getChildren().clear();
	Scene scene = new Scene(root, 540, 210);

	Media media = new Media(f3.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	mediaPlayer.setAutoPlay(true);
	MediaView mediaView3 = new MediaView(mediaPlayer);
	((Group)scene.getRoot()).getChildren().add(mediaView3);
	fxPanel3.setScene(scene);	
	
	Audio audio = Audio.getInstance();
	InputStream sound = null;
	try {
		Thread.sleep(8000);
		sound = audio.getAudio("How many times did the cow moo?", Language.ENGLISH);
	} catch (IOException | InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		audio.play(sound);
	} catch (JavaLayerException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	frame.addKeyListener(new KeyTyped()
	{
		Audio audio = Audio.getInstance();
    	InputStream sound = null;
		public void keyTyped(KeyEvent e){
			System.out.println("keyTyped: "+e.getKeyChar());
			char c=e.getKeyChar();
		  if(flag==true){	
			if(c=='2'){
				try {
	        		sound = audio.getAudio("Correct Answer!", Language.ENGLISH);
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
	        	
	        	advCountingGameScore++;
	        	
			}
			else {
				try {
	        		sound = audio.getAudio("I'm sorry... that's the wrong answer", Language.ENGLISH);
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
			flag=false;
        	return;
		}
	  }	
	});
	
	try {
		   Thread.sleep(5000);
		   frame.remove(fxPanel3);
	} catch (InterruptedException ie) {
	}
	
}

public void questionFour(){
	final JFXPanel fxPanel4 = new JFXPanel();
	frame.add(fxPanel4);
	
	final File f4 = new File("C:/Users/proga_000/Videos/dogbark1.mp4");
	
	Group root = new Group();
	root.getChildren().clear();
	Scene scene = new Scene(root, 540, 210);
	
	Media media = new Media(f4.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	mediaPlayer.setAutoPlay(true);
	MediaView mediaView = new MediaView(mediaPlayer);
	((Group)scene.getRoot()).getChildren().add(mediaView);
	
	fxPanel4.setScene(scene);
	
	Audio audio = Audio.getInstance();
	InputStream sound = null;
	try {
		Thread.sleep(3000);
		sound = audio.getAudio("How many times did the dog bark?", Language.ENGLISH);
	} catch (IOException | InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		audio.play(sound);
	} catch (JavaLayerException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	frame.addKeyListener(new KeyTyped()
	{
		Audio audio = Audio.getInstance();
    	InputStream sound = null;
		public void keyTyped(KeyEvent e){
			System.out.println("keyTyped: "+e.getKeyChar());
			char c=e.getKeyChar();
		 if(flag==true){
			if(c=='1'){
				try {
	        		sound = audio.getAudio("Correct Answer!", Language.ENGLISH);
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
	        	
	        	advCountingGameScore++;
	        	
			}
			else {
				try {
	        		sound = audio.getAudio("I'm sorry... that's the wrong answer", Language.ENGLISH);
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
			flag=false;
        	return;
		}
	  }
	});
	
	try {
		   Thread.sleep(5000);
		   ((Group)scene.getRoot()).getChildren().remove(mediaView);
		   frame.remove(fxPanel4);
	   
		} catch (InterruptedException ie) {
	}
	
}

public void questionFive(){
	final JFXPanel fxPanel5 = new JFXPanel();
	frame.add(fxPanel5);
	
	final File f5 = new File("C:/Users/proga_000/Videos/duckquack4.mp4");
	
	Group root = new Group();
	root.getChildren().clear();
	Scene scene = new Scene(root, 540, 210);
	
	Media media = new Media(f5.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	mediaPlayer.setAutoPlay(true);
	MediaView mediaView = new MediaView(mediaPlayer);
	((Group)scene.getRoot()).getChildren().add(mediaView);
	fxPanel5.setScene(scene);
	
	Audio audio = Audio.getInstance();
	InputStream sound = null;
	try {
		Thread.sleep(7000);
		sound = audio.getAudio("How many times did the duck quack?", Language.ENGLISH);
	} catch (IOException | InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		audio.play(sound);
	} catch (JavaLayerException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	frame.addKeyListener(new KeyTyped()
	{
		Audio audio = Audio.getInstance();
    	InputStream sound = null;
		public void keyTyped(KeyEvent e){
			System.out.println("keyTyped: "+e.getKeyChar());
			char c=e.getKeyChar();
		  if(flag==true){
			if(c=='4'){
				try {
	        		sound = audio.getAudio("Correct Answer!", Language.ENGLISH);
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
	        	
	        	advCountingGameScore++;
	        	
			}
			else {
				try {
	        		sound = audio.getAudio("I'm sorry... that's the wrong answer", Language.ENGLISH);
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
			flag=false;
        	return;
		}
	  }
	});
		
	try {
		   Thread.sleep(5000);
		   ((Group)scene.getRoot()).getChildren().remove(mediaView);
		   frame.remove(fxPanel5);
	   
		} catch (InterruptedException ie) {
	}
	
}


class KeyTyped implements KeyListener{
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped: "+e.getKeyChar());
    }
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}


    public static void main(String[] args) {
    	
		frame.setSize(1300,750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//introduce the game
		Audio audio = Audio.getInstance();
		InputStream sound1 = null;
		InputStream sound2 = null;
		/*try {
			sound1 = audio.getAudio("Time to play the Coutning Game Game!", Language.ENGLISH);
			sound2 = audio.getAudio("After the questions, press the number of how many sounds you heard", Language.ENGLISH);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			audio.play(sound1);
			audio.play(sound2);
		} catch (JavaLayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		//need a better way to keep the score of the game because there are 5 instances of the class
		//then there are 5 instances of the game score
		AdvCountingGame g1 = new AdvCountingGame();
		AdvCountingGame g2 = new AdvCountingGame();
		AdvCountingGame g3 = new AdvCountingGame();
		AdvCountingGame g4 = new AdvCountingGame();
		AdvCountingGame g5 = new AdvCountingGame();
		g1.questionOne();
		g2.questionTwo();
		g3.questionThree();
		g4.questionFour();
		g5.questionFive();
    }
}


