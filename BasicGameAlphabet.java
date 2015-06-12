//class for Basic Alphabet Game
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.TimerTask;
import java.util.Timer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

public class BasicGameAlphabet extends JFXPanel{
/*	JPanel cards;
	CardLayout cl;*/
	static boolean flag=true; // keeps track to take only one response per question
	static JFXPanel panel1;
	static int response=0; // tracks the response for the question
	private static int answer; // the original answer to the question
	static String username;
	static int score;
	
	public BasicGameAlphabet(){
		panel1 = this;
		score = 0;
	}
	public static void play(String name) {
		username = name;
		panel1.setSize(990,750);
	    panel1.setFocusable(true);
	
		Audio audio = Audio.getInstance();
		try {
			InputStream sound = null;
			try {
				sound = audio.getAudio("This is Basic Alphabet game. Press once to answer YES. twice to answer NO.", Language.ENGLISH);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			audio.play(sound);
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			question5(1);
			
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {

			        @Override
			        public void run() {
			            Platform.runLater(new Runnable() {
			                @Override
			                public void run() {
			                	Welcome.showBasicLessonAnimal();
			                	BasicAnimalLesson.play(username);
			                	
			                }
			            });

			        }
			    }, 10000);	


		
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
	public static void interval(){
		Audio audio = Audio.getInstance();
    	InputStream sound1 = null;
    	try {
			sound1 = audio.getAudio("Click once to Answer YES. Click twice to anser NO", Language.ENGLISH);
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
/* this function compares the right answer to
 * to the answer provided by the user
 */
public static void selectAns(){
	score=0;
	InputStream sound = null;
	InputStream sound1 = null;
	Audio audio = Audio.getInstance();
	
	System.out.println("Answer:  "+answer);
	System.out.println("response:"+ response);
		if(answer==response){
		try {
		      
    		sound = audio.getAudio("Correct Answer", Language.ENGLISH);
    		score++;
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
		
		updateDB(score);
	
}

public static void updateDB(int finalScore){
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager entitymanager = emfactory.createEntityManager();
    EntityTransaction transaction = entitymanager.getTransaction();
    
   //System.out.println("Username: " + username);
    
	transaction.begin();
   Query query1 = entitymanager.createQuery("Update student_info s SET s.basicLetterGameScore=:score WHERE s.name=:sname");
	query1.setParameter("score", finalScore);
	query1.setParameter("sname", username);
	query1.executeUpdate();
	transaction.commit();
	
}
/*This function retrieves the question and displays it on the Panel
 * for the user to visually see the question
 */
public static void question5(int ans) {
	flag=true;
	answer = ans;
	
	String str= "C:/Users/proga_000/Videos/Z.mp4" ;
	
	final File f = new File(str);
    
	Group root = new Group();
	Scene scene = new Scene(root, 540, 210);
	Media media = new Media(f.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	mediaPlayer.setAutoPlay(true);
	MediaView mediaView = new MediaView(mediaPlayer);
	
	((Group)scene.getRoot()).getChildren().add(mediaView);
	
	
	panel1.setScene(scene);	
	panel1.addMouseListener( new ClickListener() {
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
		

	//add some voice message to move to next question
	}
/*public static void question4(int ans) {
	flag=true;
	answer = ans;
	
	String str= "C:/Users/Rohith/Videos/Y.mp4" ;
	
	final File f = new File(str);
    
	Group root = new Group();
	Scene scene = new Scene(root, 540, 210);
	Media media = new Media(f.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	mediaPlayer.setAutoPlay(true);
	MediaView mediaView = new MediaView(mediaPlayer);
	
	((Group)scene.getRoot()).getChildren().add(mediaView);
	
	panel1.setScene(scene);	
	panel1.addMouseListener( new ClickListener() {
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


	//add some voice message to move to next question
	}
public static void question3(int ans) {
	flag=true;
	answer = ans;
	
	String str= "C:/Users/Rohith/Videos/X.mp4" ;
	
	final File f = new File(str);
    
	Group root = new Group();
	Scene scene = new Scene(root, 540, 210);
	Media media = new Media(f.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	mediaPlayer.setAutoPlay(true);
	MediaView mediaView = new MediaView(mediaPlayer);
	
	((Group)scene.getRoot()).getChildren().add(mediaView);
	
	panel1.setScene(scene);	
	panel1.addMouseListener( new ClickListener() {
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


	//add some voice message to move to next question
	}
public static void question2(int ans) {
	flag=true;
	answer = ans;
	
	String str= "C:/Users/Rohith/Videos/P.mp4" ;
	
	final File f = new File(str);
    
	Group root = new Group();
	Scene scene = new Scene(root, 540, 210);
	Media media = new Media(f.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	mediaPlayer.setAutoPlay(true);
	MediaView mediaView = new MediaView(mediaPlayer);
	
	((Group)scene.getRoot()).getChildren().add(mediaView);
	
	panel1.setScene(scene);	
	panel1.addMouseListener( new ClickListener() {
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


	//add some voice message to move to next question
	}
public static void question1(int ans) {
	flag=true;
	answer = ans;
	
	String str= "C:/Users/Rohith/Videos/B.mp4" ;
	
	final File f = new File(str);
    
	Group root = new Group();
	Scene scene = new Scene(root, 540, 210);
	Media media = new Media(f.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	mediaPlayer.setAutoPlay(true);
	MediaView mediaView = new MediaView(mediaPlayer);
	
	((Group)scene.getRoot()).getChildren().add(mediaView);
	
	panel1.setScene(scene);	
	panel1.addMouseListener( new ClickListener() {
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


	//add some voice message to move to next question
	}
*/

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
	


}