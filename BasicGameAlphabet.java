//class for Basic Alphabet Game
import java.awt.*;
import javax.swing.*;
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


public class BasicGameAlphabet{
	boolean flag=true; // keeps track to take only one response per question
	JPanel frame;
	static JFXPanel fxPanel;
		
public void question(String str) {
	
	final File f = new File(str);
    
	fxPanel.addMouseListener( new MouseAdapter() {
	      public void mouseClicked(MouseEvent e) {	        
	        if(e.getClickCount()==1 && flag==true) {
	        	System.out.println("Congrats!!!Right Answer");
	        	flag=false;
	        	return;
	        }
	        if (e.getClickCount() > 1 && flag==true){
	        	System.out.println("Sorry.. Wrong answer");
	        	flag=false;
	        	return;
	        }
	        
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Basic Alphabet Game");
		fxPanel = new JFXPanel();
		frame.add(fxPanel);
		frame.setSize(990,750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		BasicGameAlphabet q1 = new BasicGameAlphabet();
		BasicGameAlphabet q2 = new BasicGameAlphabet();
		BasicGameAlphabet q3 = new BasicGameAlphabet();
		BasicGameAlphabet q4 = new BasicGameAlphabet();
		BasicGameAlphabet q5 = new BasicGameAlphabet();
		String[] str = {"C:/Users/Rohith/Videos/B.mp4","C:/Users/Rohith/Videos/P.mp4","C:/Users/Rohith/Videos/X.mp4","C:/Users/Rohith/Videos/Y.mp4","C:/Users/Rohith/Videos/Z.mp4"};
		q1.question("C:/Users/Rohith/Videos/B.mp4");
		q2.question("C:/Users/Rohith/Videos/P.mp4");
		q3.question("C:/Users/Rohith/Videos/X.mp4");
		q4.question("C:/Users/Rohith/Videos/Y.mp4");
		q5.question("C:/Users/Rohith/Videos/Z.mp4");

	}



}