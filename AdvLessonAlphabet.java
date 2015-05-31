import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.*;
import javazoom.jl.decoder.JavaLayerException;
import com.gtranslate.Audio;
import com.gtranslate.Language;

class AdvLessonAlphabet extends JFrame {
	class KeyTyped extends JPanel implements KeyListener{
	    public void keyTyped(KeyEvent e) {
	    	char c=e.getKeyChar();
	        System.out.println("keyTyped: "+e.getKeyChar());
	        Audio audio = Audio.getInstance();
			InputStream sound = null;
			int ascii = 'c';
			try {
				if ((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122)){
					sound = audio.getAudio("" + c, Language.ENGLISH);
				}
				else{
					sound = audio.getAudio("", Language.ENGLISH);
				}
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
	    public void keyPressed(KeyEvent e) {
	    }
	    public void keyReleased(KeyEvent e) {
	    }
	}

    public AdvLessonAlphabet() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(990,750);

        KeyTyped key=new KeyTyped();

        key.addKeyListener(key);
        key.setFocusable(true);

        add(key);
        setVisible(true);
    }
    public static void main(String[] args) {
        new AdvLessonAlphabet();
    }
}