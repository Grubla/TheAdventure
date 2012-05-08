package se.chalmers.kangaroo.view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import se.chalmers.kangaroo.controller.GameController;
import se.chalmers.kangaroo.utils.Sound;

public class ChangeView extends JFrame implements KeyListener {

	private JPanel jp;
	private GameController gc;
	private OptionView ov;
	private HighscoreView hv;
	private MenuView mv;
	

	public ChangeView() {
		gc = new GameController(this);
		ov = new OptionView("resources/images/background.gif", this);
		hv = new HighscoreView("resources/images/background.gif", this);
		mv = new MenuView("resources/images/background.gif", this);

		jp = new JPanel(new CardLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 576);
		setResizable(false);
		Dimension win = Toolkit.getDefaultToolkit().getScreenSize();
		int width = getSize().width;
		int height = getSize().height;
		int xPos = (win.width - width) / 2;
		int yPos = (win.height - height) / 2;
		setLocation(xPos, yPos);
		jp.add(mv, "menuview");
		jp.add(gc.getGameView(), "gameview");
		jp.add(ov, "optionview");
		jp.add(hv, "highscoreview");
		jp.add(mv, "menuview");
		add(jp);
		addKeyListener(this);
		setVisible(true);
		jp.setVisible(true);
	}
	
	public void back() {
		CardLayout cl = (CardLayout) jp.getLayout();
		cl.previous(jp);
	}

	public void menuView() {
		CardLayout cl = (CardLayout) jp.getLayout();
		cl.show(jp, "menuview");
	}

	public void gameView() {
		CardLayout cl = (CardLayout) jp.getLayout();
		cl.show(jp, "gameview");
		gc.start();
	}

	public void optionView() {
		CardLayout cl = (CardLayout) jp.getLayout();
		cl.show(jp, "optionview");
	}

	public void highscoreView() {
		CardLayout cl = (CardLayout) jp.getLayout();
		cl.show(jp, "highscoreview");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		gc.keyPressed(e);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		gc.keyReleased(e);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Do nothing rly
	}
}
