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
	public static void showHomePage(){
		cl.show(cards,"Home Page");
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
		cl.show(cards, "Basic Lesson Counting");
	}
	public static void showBasicGameCounting(){
		cl.show(cards, "Basic Game Counting");
	}
	public static void showAdvLessonAlphabet(){
		cl.show(cards, "Advanced Lesson Alphabet");
	}
	public static void showAdvGameAlphabet(){
		cl.show(cards, "Advanced Game Alphabet");
	}
	public static void showAdvLessonCounting(){
		cl.show(cards, "Advanced Lesson Counting");
	}
	public static void showAdvGameCounting(){
		cl.show(cards,"Advanced Game Counting");
	}
	public static void showCheckProgress(){
		cl.show(cards,"Check Progress");
	}
	public void init(){
	
	JFrame window = new JFrame("Welcome");
	cl = new CardLayout();
	cards = new JPanel(cl);
	cards.add(new HomePage(cards,cl, window),HOMEPAGE);	
	cards.add(new CheckProgress(), "Check Progress");
    cards.add(new BasicLessonAlphabet(), "Basic Lesson Alphabet");
	cards.add(new BasicGameAlphabet(), "Basic Game Alphabet");
	cards.add(new BasicAnimalLesson(),"Basic Lesson Animal");
	cards.add(new BasicAnimalGame(),"Basic Game Animal");
	cards.add(new BasicLessonNumber(), "Basic Lesson Counting");
	cards.add(new BasicNumberGame(), "Basic Game Counting");
	cards.add(new AdvLessonAlphabet(),"Advanced Lesson Alphabet");
	cards.add(new AdvGameAlphabet(), "Advanced Game Alphabet");
	cards.add(new AdvCountingLesson(),"Advanced Lesson Counting");
	cards.add(new AdvCountingGame(),"Advanced Game Counting");
	cl.show(cards, HOMEPAGE);
	window.add(cards);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.pack();
	window.setSize(1300,750);
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

