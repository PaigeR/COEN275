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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.*;

import javazoom.jl.decoder.JavaLayerException;

import com.gtranslate.Audio;
import com.gtranslate.Language;

public class AdvGameAlphabet extends JPanel {
	static JPanel  countpanel;
	static int score;
	static String username;
	static int finalScore;
	static boolean flag=true;
	
	public AdvGameAlphabet(){
		countpanel = this;
		score = 0;
	}
	
	public static void init(String name){
		username = name;
		
		//introduce the game
				Audio audio = Audio.getInstance();
				InputStream sound1 = null;
				InputStream sound2 = null;
				try {
					countpanel.setFocusable(true);
					sound1 = audio.getAudio("Time to play the Alphabet Game!", Language.ENGLISH);
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
		
		int s1 = playnumber1();
		int s2 = playnumber2();
		int s3 = playnumber3();
		int s4 = playnumber4();
		int s5 = playnumber5();
		
		finalScore = s1+s2+s3+s4+s5;
		
		updateDB(finalScore);
			
		//countpanel.setFocusable(true);
		
	
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

		        @Override
		        public void run() {
		            Platform.runLater(new Runnable() {
		                @Override
		                public void run() {
		                	//return back to the home page
		                	Welcome.showAdvLessonCounting();
		                	AdvCountingLesson.start(username);
		                	
		                	}
		            });

		        }
		    }, 3000);	


	}

	
public static  int playnumber1(){
		flag=true;
		score=0;
	
		Audio audio = Audio.getInstance();
		InputStream sound = null;
		
		try {
			sound = audio.getAudio("Press the letter 'c'", Language.ENGLISH);
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
		
		countpanel.setFocusable(true);
		countpanel.requestFocusInWindow();
		
		KeyListener l1;	
		countpanel.addKeyListener(l1 = new KeyListener() {
			Audio audio = Audio.getInstance();
	    	InputStream sound = null;

	        @Override
	        public void keyTyped(KeyEvent e) {
	        	//panel1.setFocusable(true);
	        	System.out.println("keyTyped: "+e.getKeyChar());
				char c=e.getKeyChar();
			 if(flag==true){
				if(c=='c'){
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
		
		
		
		try {
			   Thread.sleep(5000);
			   countpanel.removeKeyListener(l1);
		   
			} catch (InterruptedException ie) {
			}
						
			return score;
			
	}
	

	public static  int playnumber2(){
		flag=true;
		score=0;
	
		Audio audio = Audio.getInstance();
		InputStream sound = null;
		
		try {
			sound = audio.getAudio("Press the letter 'b'", Language.ENGLISH);
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
		
		countpanel.setFocusable(true);
		countpanel.requestFocusInWindow();
		
		KeyListener l2;	
		countpanel.addKeyListener(l2 = new KeyListener() {
			Audio audio = Audio.getInstance();
	    	InputStream sound = null;

	        @Override
	        public void keyTyped(KeyEvent e) {
	        	//panel1.setFocusable(true);
	        	System.out.println("keyTyped: "+e.getKeyChar());
				char c=e.getKeyChar();
			 if(flag==true){
				if(c=='b'){
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
		
		
		
		try {
			   Thread.sleep(5000);
			   countpanel.removeKeyListener(l2);
		   
			} catch (InterruptedException ie) {
			}
						
			return score;
			
			
	}
	
	
	public static  int playnumber3(){
		flag=true;
		score=0;
	
		Audio audio = Audio.getInstance();
		InputStream sound = null;
		
		try {
			sound = audio.getAudio("Press the letter 'p'", Language.ENGLISH);
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
		
		countpanel.setFocusable(true);
		countpanel.requestFocusInWindow();
		
		KeyListener l3;	
		countpanel.addKeyListener(l3 = new KeyListener() {
			Audio audio = Audio.getInstance();
	    	InputStream sound = null;

	        @Override
	        public void keyTyped(KeyEvent e) {
	        	//panel1.setFocusable(true);
	        	System.out.println("keyTyped: "+e.getKeyChar());
				char c=e.getKeyChar();
			 if(flag==true){
				if(c=='p'){
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
		
		
		
		try {
			   Thread.sleep(5000);
			   countpanel.removeKeyListener(l3);
		   
			} catch (InterruptedException ie) {
			}
						
			return score;
			
			
	}
	
	
	public static  int playnumber4(){
		flag=true;
		score=0;
	
		Audio audio = Audio.getInstance();
		InputStream sound = null;
		
		try {
			sound = audio.getAudio("Press the letter 'y'", Language.ENGLISH);
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
		
		countpanel.setFocusable(true);
		countpanel.requestFocusInWindow();
		
		KeyListener l4;	
		countpanel.addKeyListener(l4 = new KeyListener() {
			Audio audio = Audio.getInstance();
	    	InputStream sound = null;

	        @Override
	        public void keyTyped(KeyEvent e) {
	        	//panel1.setFocusable(true);
	        	System.out.println("keyTyped: "+e.getKeyChar());
				char c=e.getKeyChar();
			 if(flag==true){
				if(c=='y'){
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
		
		
		
		try {
			   Thread.sleep(5000);
			   countpanel.removeKeyListener(l4);
		   
			} catch (InterruptedException ie) {
			}
						
			return score;
			
			
	}
	
	
	public static  int playnumber5(){
		flag=true;
		score=0;
	
		Audio audio = Audio.getInstance();
		InputStream sound = null;
		
		try {
			sound = audio.getAudio("Press the letter 'e", Language.ENGLISH);
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
		
		countpanel.setFocusable(true);
		countpanel.requestFocusInWindow();
		
		KeyListener l5;	
		countpanel.addKeyListener(l5 = new KeyListener() {
			Audio audio = Audio.getInstance();
	    	InputStream sound = null;

	        @Override
	        public void keyTyped(KeyEvent e) {
	        	System.out.println("keyTyped: "+e.getKeyChar());
				char c=e.getKeyChar();
			 if(flag==true){
				if(c=='e'){
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
		
		
		
		try {
			   Thread.sleep(5000);
			   countpanel.removeKeyListener(l5);
		   
			} catch (InterruptedException ie) {
			}
						
			return score;
					
	}

	
public static void updateDB(int finalScore){
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager entitymanager = emfactory.createEntityManager();
    EntityTransaction transaction = entitymanager.getTransaction();
    
   //System.out.println("Username: " + username);
    
	transaction.begin();
   Query query1 = entitymanager.createQuery("Update student_info s SET s.advLetterGameScore=:score WHERE s.name=:sname");
	query1.setParameter("score", finalScore);
	query1.setParameter("sname", username);
	query1.executeUpdate();
	transaction.commit();
} 

}