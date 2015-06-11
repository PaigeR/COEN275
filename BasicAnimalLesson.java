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


public class BasicAnimalLesson extends JFXPanel {
/*		JPanel cards;
		CardLayout cl;
		JFrame window;*/
	static JFXPanel panel;
public BasicAnimalLesson() {
	panel = this;

}
public static JFXPanel getPanel(){
	return panel;
}
public static void play(){
	Audio audio = Audio.getInstance();
	try {
		InputStream sound = null;
		try {
			sound = audio.getAudio("This is basic Animal Lesson", Language.ENGLISH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		audio.play(sound);
	} catch (JavaLayerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	
final File f = new File("C:/Users/Rohith/Videos/X.mp4");

	Group root = new Group();
	Scene scene = new Scene(root, 540, 210);
	Media media = new Media(f.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	mediaPlayer.setAutoPlay(true);
	MediaView mediaView = new MediaView(mediaPlayer);

	((Group)scene.getRoot()).getChildren().add(mediaView);

	panel.setScene(scene);
	System.out.println("this is test");
	InputStream sound1 = null;
	try {
		sound1 = audio.getAudio("This is Advanced Counting Lesson", Language.ENGLISH);
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


	Timer timer = new Timer();
	timer.schedule(new TimerTask() {

	        @Override
	        public void run() {
	            Platform.runLater(new Runnable() {
	                @Override
	                public void run() {
	                /*	Welcome.showBasicGameAnimal();
	                	BasicAnimalGame.init();
	                	uncomment when the basicAnimalGame is fixed
	                */
	                	Welcome.showBasicLessonCounting();
	                	BasicLessonNumber.play();
	            		
	                }
	            });

	        }
	    }, 9000);	



}

	
	


}
