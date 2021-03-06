//class for Alphabet lesson
import java.awt.*;

import javax.swing.*;

import javazoom.jl.decoder.JavaLayerException;

import com.gtranslate.Audio;
import com.gtranslate.Language;
import com.sun.javafx.application.PlatformImpl;

import java.util.Timer;
import java.awt.event.*;
import java.io.*;
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


public class BasicLessonNumber extends JFXPanel {
	
	static JFXPanel panel;
	static String username;
	
	
public BasicLessonNumber() {
	panel = this;

}
public static JFXPanel getPanel(){
	return panel;
}
public static void play(String name){
	username = name;
	Audio audio = Audio.getInstance();
	try {
		InputStream sound = null;
		try {
			sound = audio.getAudio("This is Basic Number Lesson", Language.ENGLISH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		audio.play(sound);
	} catch (JavaLayerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
final File f = new File("C:/Users/proga_000/Videos/FiveLittleMonkeys.mp4");


	Group root = new Group();
	Scene scene = new Scene(root, 540, 210);
	Media media = new Media(f.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	mediaPlayer.setAutoPlay(true);
	MediaView mediaView = new MediaView(mediaPlayer);

	((Group)scene.getRoot()).getChildren().add(mediaView);
	panel.setScene(scene);
	

	Timer timer = new Timer();
	timer.schedule(new TimerTask() {

	        @Override
	        public void run() {
	            Platform.runLater(new Runnable() {
	                @Override
	                public void run() {
	                	Welcome.showBasicGameCounting();
	                	BasicNumberGame.init(username);
	                	}
	            });

	        }
	    }, 311000);	



}

	
	


}