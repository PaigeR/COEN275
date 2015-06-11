import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.*;


public class Welcome  extends JPanel{
	static JPanel cards; // panel that uses cards
    private static CardLayout cl;
    final static String HOMEPAGE = "Home Page";
    final static String BLALPHABET = "Basic Lesson Alphabet";
    final static String BGALPHABET = "Basic Game Alphabet";
    private BasicLessonAlphabet basiclessonalphabet;
    private BasicGameAlphabet basicgamealphabet;
    private HomePage homepage;
	public Welcome(){
		init();
	}
	public static void showBasicLessonAlphabet(){
		cl.show(cards, "Basic Lesson Alphabet");
	}
	public static void showBasicGameAlphabet(){
		cl.show(cards, "Basic Game Alphabet");
	}
	public static void showBasicLessonAnimal(){
		cl.show(cards, "Basic Lesson Animal");
	}
	public static void showBasicGameAnimal(){
		cl.show(cards, "Basic Game Animal");
	}
	public static void showBasicLessonCounting(){
		cl.show(cards, "Basic Lesson counting");
	}
	public void init(){
	
	JFrame window = new JFrame("This is welcome");
	cl = new CardLayout();
	cards = new JPanel(cl);
	cards.add(new HomePage(cards,cl, window),HOMEPAGE);	
    cards.add(new BasicLessonAlphabet(), "Basic Lesson Alphabet");
	cards.add(new BasicGameAlphabet(), "Basic Game Alphabet");
	cards.add(new BasicAnimalLesson(),"Basic Lesson Animal");
	cards.add(new BasicLessonNumber(), "Basic Lesson counting");

	//cards.add(new BasicLessonAlphabet(), BLALPHABET);
	//cards.add(new BasicGameAlphabet(), BGALPHABET);
    cl.show(cards, HOMEPAGE);
	window.add(cards);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.pack();
	window.setVisible(true);
	
    
	}
	public static void main(String[] args){
		 EventQueue.invokeLater(new Runnable() {
		      @Override
		      public void run() {
		  		Welcome w = new Welcome();
		      }
		    });
	}
	
}

