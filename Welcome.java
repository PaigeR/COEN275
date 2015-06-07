import java.awt.CardLayout;

import javax.swing.*;


public class Welcome  extends JPanel{
	JPanel cards; // panel that uses cards
    private CardLayout cl;
    final static String HOMEPAGE = "Home Page";
    final static String BLALPHABET = "Basic Lesson Alphabet";
    final static String BGALPHABET = "Basic Game Alphabet";
    private BasicLessonAlphabet basiclessonalphabet;
    private BasicGameAlphabet basicgamealphabet;
    private HomePage homepage;
	public Welcome(){
		init();
	}
	public void init(){
	
	JFrame window = new JFrame("This is welcome");
	//BasicLessonAlphabet basiclessonalphabet = new BasicLessonAlphabet();
	cl = new CardLayout();
	cards = new JPanel(cl);
	cards.add(new HomePage(cards,cl, window),HOMEPAGE);
	//cards.add(new BasicLessonAlphabet(), BLALPHABET);
	//cards.add(new BasicGameAlphabet(), BGALPHABET);
    //cl.show(cards, HOMEPAGE);
	window.add(cards);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.pack();
	window.setVisible(true);
    
	}
	public static void main(String[] args){
		Welcome w = new Welcome();
	}
	
}

