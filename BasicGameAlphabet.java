//class for Basic Alphabet Game
import java.awt.*;

import javax.swing.*;

import javazoom.jl.decoder.JavaLayerException;

import com.gtranslate.Audio;
import com.gtranslate.Language;

import java.awt.event.*;
import java.io.*;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class BasicGameAlphabet extends JPanel{
	JPanel cards;
	CardLayout cl;
	JFrame frame;
	boolean flag=true; // keeps track to take only one response per question
	static JFXPanel fxPanel;
	int response=0; // tracks the response for the question
	private int answer; // the original answer to the question
	public BasicGameAlphabet(JFrame win,JPanel car,CardLayout clayout){
		cards=car;
		cl=clayout;
		frame= win;
		init();
		
	}
	public void init() {
		fxPanel = new JFXPanel();
		frame.add(fxPanel);
		frame.setSize(990,750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Audio audio = Audio.getInstance();
		try {
			InputStream sound = null;
			try {
				sound = audio.getAudio("This is Basic Alphabet game", Language.ENGLISH);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			audio.play(sound);
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		question1(1);
		interval();
		question2(1);
		interval();
		question3(2);
		interval();
		question4(1);
		interval();
		question5(1);
		interval();
		try {
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

		
	}
	public void interval(){
		Audio audio = Audio.getInstance();
    	InputStream sound1 = null;
    	try {
			sound1 = audio.getAudio("Click once to Answer YES. Double Click to NO", Language.ENGLISH);
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
/* this function compares the right answer to
 * to the answer provided by the user
 */
public void selectAns(){
	InputStream sound = null;
	InputStream sound1 = null;
	Audio audio = Audio.getInstance();
	
	System.out.println("Answer:  "+answer);
	System.out.println("response:"+ response);
		if(answer==response){
		try {
		      
    		sound = audio.getAudio("Correct Answer", Language.ENGLISH);
    		System.out.println("Correct Answer");
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
		else {
			try {
				
	    		sound1 = audio.getAudio("SORRY. Wrong answer", Language.ENGLISH);
	    		System.out.println("Sorry. Wrong Answer");
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
			
		}
	
}
/*This function retrieves the question and displays it on the Panel
 * for the user to visually see the question
 */
public void question5(int ans) {
	flag=true;
	String str= "C:/Users/Rohith/Videos/Z.mp4" ;
	final File f = new File(str);
	answer = ans;
    
	fxPanel.addMouseListener( new ClickListener() {
		Audio audio = Audio.getInstance();
    	public void singleClick(MouseEvent e)
        {	
        	if(flag==true){
        		response=1;
        	selectAns();
        	}
        	flag=false;
        	response=0;
        	return;
        } 
        public void doubleClick(MouseEvent e)
        {	
        	if(flag==true){
        		response=2;
        		selectAns();
        	}
        	flag=false;
        	response=0;
        	return;
        }
	      });

	Group root = new Group();
	Scene scene = new Scene(root, 540, 210);
	Media media = new Media(f.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	mediaPlayer.setAutoPlay(true);
	MediaView mediaView = new MediaView(mediaPlayer);
	((Group)scene.getRoot()).getChildren().add(mediaView);
	fxPanel.setScene(scene);
	//add some voice message to move to next question
	try {
		   Thread.sleep(9000);
	   
		} catch (InterruptedException ie) {
		}		
}

public void question4(int ans) {
	flag=true;
	String str= "C:/Users/Rohith/Videos/Y.mp4" ;
	final File f = new File(str);
	answer = ans;
    
	fxPanel.addMouseListener( new ClickListener() {
		Audio audio = Audio.getInstance();
    	public void singleClick(MouseEvent e)
        {	
        	if(flag==true){
        		response=1;
        	selectAns();
        	}
        	flag=false;
        	response=0;
        	return;
        } 
        public void doubleClick(MouseEvent e)
        {	
        	if(flag==true){
        		response=2;
        		selectAns();
        	}
        	flag=false;
        	response=0;
        	return;
        }
	      });

	Group root = new Group();
	Scene scene = new Scene(root, 540, 210);
	Media media = new Media(f.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	mediaPlayer.setAutoPlay(true);
	MediaView mediaView = new MediaView(mediaPlayer);
	((Group)scene.getRoot()).getChildren().add(mediaView);
	fxPanel.setScene(scene);
	//add some voice message to move to next question
	try {
		   Thread.sleep(9000);
	   
		} catch (InterruptedException ie) {
		}	
	
}

public void question3(int ans) {
	flag=true;
	String str= "C:/Users/Rohith/Videos/X.mp4" ;
	final File f = new File(str);
	answer = ans;
    
	fxPanel.addMouseListener( new ClickListener() {
		Audio audio = Audio.getInstance();
    	public void singleClick(MouseEvent e)
        {	
        	if(flag==true){
        		response=1;
        	selectAns();
        	}
        	flag=false;
        	response=0;
        	return;
        } 
        public void doubleClick(MouseEvent e)
        {	
        	if(flag==true){
        		response=2;
        		selectAns();
        	}
        	flag=false;
        	response=0;
        	return;
        }
	      });

	Group root = new Group();
	Scene scene = new Scene(root, 540, 210);
	Media media = new Media(f.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	mediaPlayer.setAutoPlay(true);
	MediaView mediaView = new MediaView(mediaPlayer);
	((Group)scene.getRoot()).getChildren().add(mediaView);
	fxPanel.setScene(scene);
	//add some voice message to move to next question
	try {
		   Thread.sleep(9000);
	   
		} catch (InterruptedException ie) {
		}	
	
}

public void question2(int ans) {
	flag=true;
	String str= "C:/Users/Rohith/Videos/P.mp4" ;
	final File f = new File(str);
	answer = ans;
    
	fxPanel.addMouseListener( new ClickListener() {
		Audio audio = Audio.getInstance();
    	public void singleClick(MouseEvent e)
        {	
        	if(flag==true){
        		response=1;
        	selectAns();
        	}
        	flag=false;
        	response=0;
        	return;
        } 
        public void doubleClick(MouseEvent e)
        {	
        	if(flag==true){
        		response=2;
        		selectAns();
        	}
        	flag=false;
        	response=0;
        	return;
        }
	      });

	Group root = new Group();
	Scene scene = new Scene(root, 540, 210);
	Media media = new Media(f.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	mediaPlayer.setAutoPlay(true);
	MediaView mediaView = new MediaView(mediaPlayer);
	((Group)scene.getRoot()).getChildren().add(mediaView);
	fxPanel.setScene(scene);
	//add some voice message to move to next question
	try {
		   Thread.sleep(9000);
	   
		} catch (InterruptedException ie) {
		}	
	
}
public void question1(int ans) {
	flag=true;
	String str= "C:/Users/Rohith/Videos/B.mp4" ;
	final File f = new File(str);
	answer = ans;
    
	fxPanel.addMouseListener( new ClickListener() {
		Audio audio = Audio.getInstance();
    	public void singleClick(MouseEvent e)
        {	
        	if(flag==true){
        		response=1;
        	selectAns();
        	}
        	flag=false;
        	response=0;
        	return;
        } 
        public void doubleClick(MouseEvent e)
        {	
        	if(flag==true){
        		response=2;
        		selectAns();
        	}
        	flag=false;
        	response=0;
        	return;
        }
	      });

	Group root = new Group();
	Scene scene = new Scene(root, 540, 210);
	Media media = new Media(f.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	mediaPlayer.setAutoPlay(true);
	MediaView mediaView = new MediaView(mediaPlayer);
	((Group)scene.getRoot()).getChildren().add(mediaView);
	fxPanel.setScene(scene);
	//add some voice message to move to next question
	try {
		   Thread.sleep(9000);
	   
		} catch (InterruptedException ie) {
		}	
	
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
	


}