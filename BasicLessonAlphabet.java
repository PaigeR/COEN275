//class for Alphabet lesson
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


public class BasicLessonAlphabet extends JFXPanel{
		JPanel cards;
		CardLayout cl;
		JFrame window;
public BasicLessonAlphabet(JFrame win,JPanel car,CardLayout clayout) {
	cards=car;
	cl=clayout;
	window= win;
	play();
}

public void play(){
	
	window.add(this);
	window.setSize(990,750);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setVisible(true);
	
	
final File f = new File("C:/Users/Rohith/Videos/AForAppleSong.mp4");
	
	Group root = new Group();
	Scene scene = new Scene(root, 540, 210);
	Media media = new Media(f.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	mediaPlayer.setAutoPlay(true);
	MediaView mediaView = new MediaView(mediaPlayer);
	
	((Group)scene.getRoot()).getChildren().add(mediaView);
	
	this.setScene(scene);
	
	cards.add(new BasicGameAlphabet(window,cards,cl), "Basic Game Alphabet");
    cl.show(cards, "Basic Game Alphabet");

}
	
	
	


}