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

import javafx.embed.swing.JFXPanel;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.*;

import javazoom.jl.decoder.JavaLayerException;

import com.gtranslate.Audio;
import com.gtranslate.Language;


public class BasicAnimalGame extends JPanel{

	boolean flag=true; // keeps track to take only one response per question
	int score;
	static JPanel panel1;
	static JPanel panel2;
	static int basicAnimalGameScore = 0;
	static BufferedImage img;
	static String username;
	
	public BasicAnimalGame(String name){
		username = name;
		init();
	}
	
	public BasicAnimalGame(){
		//do nothing
	}
	
	public void init(){
		JFrame frame = new JFrame("Basic Animal Game");
		//create the background panel that is the picture
		BasicAnimalGame bg = new BasicAnimalGame();
		JPanel panel2 = bg.new ContentPanel();
		panel2.setOpaque(true);
		panel2.setLayout(new BorderLayout());
		frame.setContentPane(panel2); 
		panel1 = new JPanel();
		panel1.setOpaque(false);
		//add panel1 to the background panel
		panel2.add(panel1, BorderLayout.CENTER);
		frame.setSize(990,750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//introduce the game
		Audio audio = Audio.getInstance();
		InputStream sound1 = null;
		InputStream sound2 = null;
		try {
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
		
		//need a better way to keep the score of the game because there are 5 instances of the class
		//then there are 5 instances of the game score 
		BasicAnimalGame q1 = new BasicAnimalGame();
		BasicAnimalGame q2 = new BasicAnimalGame();
		BasicAnimalGame q3 = new BasicAnimalGame();
		BasicAnimalGame q4 = new BasicAnimalGame();
		BasicAnimalGame q5 = new BasicAnimalGame();

		int s1 = q1.questionOne();
		int s2 = q2.questionTwo();
		int s3 = q3.questionThree();
		int s4 = q4.questionFour();
		int s5 = q5.questionFive();
		
		basicAnimalGameScore = s1+s2+s3+s4+s5;
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PersistenceUnit");
	    EntityManager entitymanager = emfactory.createEntityManager();
	    
	    //need to figure out how to get the name of the user
	    Query query1 = entitymanager.createQuery("Update student_info s SET s.basicAnimalGameScore=:score WHERE s.name=:sname");
    	query1.setParameter("score", basicAnimalGameScore);
    	query1.setParameter("name", username);

	}
	
		
public int questionOne() {
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
	
	panel1.addMouseListener(new ClickListener()
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
	   
		} catch (InterruptedException ie) {
		}
	
	return score;
}

public int questionTwo() {
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
	
    
	panel1.addMouseListener(new ClickListener()
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
	   
		} catch (InterruptedException ie) {
		}
	return score;
}

public int questionThree() {
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
	
    
	panel1.addMouseListener(new ClickListener()
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
	   
		} catch (InterruptedException ie) {
		}
	
	return score;
	
}

public int questionFour() {
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
	
    
	panel1.addMouseListener(new ClickListener()
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
	   
		} catch (InterruptedException ie) {
		}
	
	return score;
	
}

public int questionFive() {
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
	
    
	panel1.addMouseListener(new ClickListener()
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
	   
		} catch (InterruptedException ie) {
		}
	
	return score;
	
}

public static class ClickListener extends MouseAdapter implements ActionListener
{
    static final int clickInterval = (Integer)Toolkit.getDefaultToolkit().
        getDesktopProperty("awt.multiClickInterval");

    MouseEvent lastEvent;
    Timer timer;

    public ClickListener()
    {
        this(clickInterval);
    }

    public ClickListener(int delay)
    {
        timer = new Timer( delay, this);
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
}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicAnimalGame game1 = new BasicAnimalGame("Paige Rogalski");
	}
}
