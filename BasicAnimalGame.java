//class to play the basic animal game
//one click = yes, two clicks = no 

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.*;

import javazoom.jl.decoder.JavaLayerException;

import com.gtranslate.Audio;
import com.gtranslate.Language;


public class BasicAnimalGame extends JPanel{

	static boolean flag=true; // keeps track to take only one response per question
	static int score;
	static JPanel panel1;
	static JPanel panel2;
	static int basicAnimalGameScore = 0;
	static BufferedImage img;
	static String username;
	
	public BasicAnimalGame(){
		panel1 = this;
		score = 0;
	}
	
	
	
	public static void init(String name){
		username = name;
		panel1.setSize(990,750);
	
		//panel1.requestFocusInWindow();
		
		//introduce the game
		Audio audio = Audio.getInstance();
		InputStream sound1 = null;
		InputStream sound2 = null;
		try {
			panel1.setFocusable(true);
			sound1 = audio.getAudio("Time to play the Animal Game!", Language.ENGLISH);
			sound2 = audio.getAudio("After the questions, press once for YES and twice for NO", Language.ENGLISH);
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
		}
		
		int s1 = questionOne();
		int s2 = questionTwo();
		int s3 = questionThree();
		int s4 = questionFour();
		int s5 = questionFive();
		
		
		basicAnimalGameScore = s1+s2+s3+s4+s5;
		System.out.println("Score: " + basicAnimalGameScore);
		updateDB(basicAnimalGameScore);
		
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

		        @Override
		        public void run() {
		            Platform.runLater(new Runnable() {
		                @Override
		                public void run() {
		                	Welcome.showBasicLessonCounting();
		                	BasicLessonNumber.play(username);
		                	
		                	}
		            });

		        }
		    }, 5000);	


	}

public static void updateDB(int finalScore){
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager entitymanager = emfactory.createEntityManager();
    EntityTransaction transaction = entitymanager.getTransaction();
    
   //System.out.println("Username: " + username);
    
	transaction.begin();
   Query query1 = entitymanager.createQuery("Update student_info s SET s.basicAnimalGameScore=:score WHERE s.name=:sname");
	query1.setParameter("score", finalScore);
	query1.setParameter("sname", username);
	query1.executeUpdate();
	transaction.commit();
	
}
		
public static int questionOne() {
	score = 0;
	flag=true;
	Audio audio = Audio.getInstance();
	InputStream sound = null;
	
	try {
		sound = audio.getAudio("This animal goes meow meow meow... Is it a dog?", Language.ENGLISH);
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
	
	MouseListener l1;
	panel1.addMouseListener(l1 = new ClickListener()
    {
		Audio audio = Audio.getInstance();
    	InputStream sound = null;
        public void singleClick(MouseEvent e)
        {
        	if(flag == true){
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

        public void doubleClick(MouseEvent e)
        {
        	if(flag==true){
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
        	}
        	score++;
        	flag=false;
        	return;
        } 
	        
	 });
	
	//add some voice message to move to next question
	try {
		   Thread.sleep(5000);
		   panel1.removeMouseListener(l1);
	   
		} catch (InterruptedException ie) {
		}
	
	return score;
}

public static int questionTwo() {
	score = 0; 
	flag=true;
	Audio audio = Audio.getInstance();
	InputStream sound = null;
	try {
		sound = audio.getAudio("This animal goes moooo moooo moooo... Is it a cow?", Language.ENGLISH);
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
	
    MouseListener l2;
	panel1.addMouseListener(l2 = new ClickListener()
    {
		Audio audio = Audio.getInstance();
    	InputStream sound = null;
    	public void singleClick(MouseEvent e)
        {
        	if(flag==true){
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
        	}
        	score++;
        	flag=false;
        	return;
        } 
        public void doubleClick(MouseEvent e)
        {
        	if(flag==true){
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

	        
	 });
	
	//add some voice message to move to next question
	try {
		   Thread.sleep(5000);
		   panel1.removeMouseListener(l2);
	   
		} catch (InterruptedException ie) {
		}
	return score;
}

public static int questionThree() {
	score=0;
	flag=true;
	Audio audio = Audio.getInstance();
	InputStream sound = null;
	try {
		sound = audio.getAudio("This animal goes cluck cluck cluck... Is it a chicken?", Language.ENGLISH);
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
	
    MouseListener l3;
	panel1.addMouseListener(l3 = new ClickListener()
    {
		Audio audio = Audio.getInstance();
    	InputStream sound = null;
        public void doubleClick(MouseEvent e)
        {
        	if(flag == true){
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

        public void singleClick(MouseEvent e)
        {
        	if(flag==true){
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
        	}
        	score++;
        	flag=false;
        	return;
        } 
	        
	 });
	
	//add some voice message to move to next question
	try {
		   Thread.sleep(5000);
		   panel1.removeMouseListener(l3);
	   
		} catch (InterruptedException ie) {
		}
	
	return score;
	
}

public static int questionFour() {
	score=0;
	flag=true;
	Audio audio = Audio.getInstance();
	InputStream sound = null;
	try {
		sound = audio.getAudio("This animal goes oink oink oink... Is it a horse?", Language.ENGLISH);
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
	
    MouseListener l4;
	panel1.addMouseListener(l4 = new ClickListener()
    {
		Audio audio = Audio.getInstance();
    	InputStream sound = null;
        public void singleClick(MouseEvent e)
        {
        	if(flag == true){
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

        public void doubleClick(MouseEvent e)
        {
        	if(flag==true){
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
        	}
        	score++;
        	flag=false;
        	return;
        } 
	        
	 });
	
	//add some voice message to move to next question
	try {
		   Thread.sleep(5000);
		   panel1.removeMouseListener(l4);
	   
		} catch (InterruptedException ie) {
		}
	
	return score;
	
}

public static int questionFive() {
	score=0;
	flag=true;
	Audio audio = Audio.getInstance();
	InputStream sound = null;
	try {
		sound = audio.getAudio("This animal goes baa baa baa... Is it a sheep?", Language.ENGLISH);
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
	
    MouseListener l5;
	panel1.addMouseListener(l5 = new ClickListener()
    {
		Audio audio = Audio.getInstance();
    	InputStream sound = null;
        public void doubleClick(MouseEvent e)
        {
        	if(flag == true){
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

        public void singleClick(MouseEvent e)
        {
        	if(flag==true){
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
        	}
        	score++;
        	flag=false;
        	return;
        } 
	        
	 });
	
	//add some voice message to move to next question
	try {
		   Thread.sleep(5000);
		   panel1.removeMouseListener(l5);
	   
		} catch (InterruptedException ie) {
		}
	
	return score;
	
}

public static class ClickListener extends MouseAdapter implements ActionListener
{
    static final int clickInterval = (Integer)Toolkit.getDefaultToolkit().
        getDesktopProperty("awt.multiClickInterval");

    MouseEvent lastEvent;
    javax.swing.Timer timer;

    public ClickListener()
    {
        this(clickInterval);
    }

    public ClickListener(int delay)
    {
        timer = new javax.swing.Timer( delay, this);
    }

    public void mouseClicked (MouseEvent e)
    {
        if (e.getClickCount() > 2) return;

        lastEvent = e;

        if (timer.isRunning())
        {
            timer.stop();
            doubleClick( lastEvent );
        }
        else
        {
            timer.restart();
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        timer.stop();
        singleClick( lastEvent );
    }

    public void singleClick(MouseEvent e) {}
    public void doubleClick(MouseEvent e) {}
    
}
/*
//Class to create a panel with a background image
public class ContentPanel extends JPanel {
	  Image bgimage = null;

	  ContentPanel() {
	    MediaTracker mt = new MediaTracker(this);
	    bgimage = Toolkit.getDefaultToolkit().getImage("C:/Users/proga_000/Pictures/animals.png");
	    mt.addImage(bgimage, 0);
	    try {
	      mt.waitForAll();
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	  }
	  @Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    int imwidth = bgimage.getWidth(null);
	    int imheight = bgimage.getHeight(null);
	    g.drawImage(bgimage, 1, 1, null);
	  }
}*/
}
