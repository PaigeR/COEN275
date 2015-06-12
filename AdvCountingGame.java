//class for Basic Alphabet Game
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.TimerTask;
import java.util.Timer;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


import javazoom.jl.decoder.JavaLayerException;

import com.gtranslate.Audio;
import com.gtranslate.Language;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AdvCountingGame extends JFXPanel{
/*	JPanel cards;
	CardLayout cl;*/
	static int score;
	static boolean flag=true; // keeps track to take only one response per question
	static JFXPanel panel1;
	static int response=0; // tracks the response for the question
	private static int answer; // the original answer to the question
	static String username;
	
	
	public AdvCountingGame(){
		panel1 = this;
		score = 0;
	
	}
	
	public static void play(String name) {
		username = name;
	
		Audio audio = Audio.getInstance();
		try {
			InputStream sound = null;
			try {
				sound = audio.getAudio("This is Advanced Counting Game.", Language.ENGLISH);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			audio.play(sound);
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		questionFive();
		
		panel1.addKeyListener(new KeyListener() {
			Audio audio = Audio.getInstance();
	    	InputStream sound = null;

	        @Override
	        public void keyTyped(KeyEvent e) {
	        	//panel1.setFocusable(true);
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
		        	
		        	score++;
		        	updateDB(score);
		        	return;
		        	
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
			                	Welcome.showHomePage();	
			                }
			            });

			        }
			    }, 16000);	


		
		/*try {
			InputStream sound1 = null;
			try {
				sound1 = audio.getAudio("You have successfully completed Basic Alphabet Game!!!", Language.ENGLISH);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			audio.play(sound1);
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}
	
	public static void questionFive(){
		//JFrame frame = new JFrame();
		
		final File f5 = new File("C:/Users/proga_000/Videos/duckquack4.mp4");
		
		Group root = new Group();
		root.getChildren().clear();
		Scene scene = new Scene(root, 540, 210);
		
		Media media = new Media(f5.toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		((Group)scene.getRoot()).getChildren().add(mediaView);
		panel1.setScene(scene);
			
			Timer timer2 = new Timer();
			timer2.schedule(new TimerTask() {

			        @Override
			        public void run() {
			            Platform.runLater(new Runnable() {
			                @Override
			                public void run() {
			                	askQuestion();
			                }
			            });

			        }
			    }, 7000);	
			
		
		
		return;
			
		
		
		//return score;
	}

public static void askQuestion(){
	
	Audio audio = Audio.getInstance();
	InputStream sound = null;
	try{
		sound = audio.getAudio("How many times did the duck quack?", Language.ENGLISH);
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
	return;
}

static void updateDB(int finalScore){
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager entitymanager = emfactory.createEntityManager();
    EntityTransaction transaction = entitymanager.getTransaction();
    
   //System.out.println("Username: " + username);
    
	transaction.begin();
   Query query1 = entitymanager.createQuery("Update student_info s SET s.advCountingGameScore=:score WHERE s.name=:sname");
	query1.setParameter("score", finalScore);
	query1.setParameter("sname", username);
	query1.executeUpdate();
	transaction.commit();
	
}


}