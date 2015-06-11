//Class to play the advanced counting lesson video
//Video copyright goes to Bounce Patrol

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class AdvCountingLesson extends JFXPanel {
	static JFXPanel advLPanel;
	public AdvCountingLesson(){
		advLPanel= this;
	}
	

	public static void start() {
		final File f = new File("C:/Users/Rohith/Videos/X.mp4");
		
		Group root = new Group();
		Scene scene = new Scene(root, 540, 210);
		Media media = new Media(f.toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		
		((Group)scene.getRoot()).getChildren().add(mediaView);
		
		advLPanel.setScene(scene);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

		        @Override
		        public void run() {
		            Platform.runLater(new Runnable() {
		                @Override
		                public void run() {
		                	
		                }
		            });

		        }
		    }, 9000);	

		
	}	
	
}
