import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Locale;
import java.util.Random;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class BasicNumberGameVer1 extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int correct;
	public int wrong;
	public String key;
	public Integer keynumber;
	int number;
	JFrame frame;
	Synthesizer  synthesizer;
	boolean waitForInput;
	Thread t;
	
	public BasicNumberGameVer1(){
		frame = new JFrame("Basic Number Game");
		frame.add(this);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		KeyListener listener = new MyKeyListener();
		frame.addKeyListener(listener);
		setFocusable(true);
		
		try{
			System.setProperty("freetts.voices","com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
			Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
			synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
			synthesizer.allocate();
			synthesizer.resume();
		} catch (Exception e){}
	}
	
	public static void main(String[] args) {
		BasicNumberGameVer1 basic = new BasicNumberGameVer1();
		basic.playnumber1();
	}

	public class MyKeyListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if(!waitForInput){
				return;
			}else{
				waitForInput=false;
			}
			System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
			key= KeyEvent.getKeyText(e.getKeyCode());
			int a;
			try{
				a= keynumber.valueOf(key);
			}catch (java.lang.NumberFormatException e1){
				System.out.println("That is not a correct input , press a number key");
				key = null;
				t.interrupt();
				return;
			}
			
			
			if (a ==number){
				System.out.println(a);
				System.out.println(" That is correct!, will interrupt");
				try{
				synthesizer.speakPlainText("That is correct! ", null);   
				synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
				} catch (Exception e1){
					e1.getStackTrace();
				}
				System.out.println("interrupting");
				t.interrupt();				
				correct ++;				
			} else {
				System.out.println(" That is wrong :( Try again)");
				waitForInput = true;
				System.out.println(a);
				wrong++;
				try{
					synthesizer.speakPlainText("That is wrong! Try again", null);
					synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
					} catch (Exception e2){
						e2.getStackTrace();
					}
				}
				t.interrupt();
				key = null;
			}
	}
	
	public  void playnumber1(){
		Random rand = new Random();
		t = Thread.currentThread();
		
		while (true){
			number = rand.nextInt(6);
			if(number==0){
				System.out.println("0");
			}
			try
			{
				synthesizer.speakPlainText("Press the number " + number , null);   	   
				synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
				waitForInput = true;
				t.sleep(10000);
			}
			catch( InterruptedException i)
			{
				System.out.println("continuing");
				continue;
			}
		   catch(Exception e)
		   {
		     e.printStackTrace();
		   }
		}
	}
}