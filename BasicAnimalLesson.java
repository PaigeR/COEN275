//Class to play the basic animal lesson video 
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


public class BasicAnimalLesson extends JPanel{
		
public static void start() {
	JFrame frame = new JFrame("Basic Animal Lesson");
	final JFXPanel fxPanel = new JFXPanel();
	frame.add(fxPanel);
	frame.setSize(990,750);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	
	final File f = new File("C:/Users/proga_000/Videos/FarmAnimalsSong.mp4");
	
	Group root = new Group();
	Scene scene = new Scene(root, 540, 210);
	Media media = new Media(f.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	mediaPlayer.setAutoPlay(true);
	MediaView mediaView = new MediaView(mediaPlayer);
	
	((Group)scene.getRoot()).getChildren().add(mediaView);
	
	fxPanel.setScene(scene);
}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                start();
            }
        });
		
		
	}



}
