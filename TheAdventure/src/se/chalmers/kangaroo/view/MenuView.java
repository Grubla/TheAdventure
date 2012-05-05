package se.chalmers.kangaroo.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;



/**
 * The view of the game.
 * 
 * @author twist3r
 * @modifiedby arvidk
 *
 */
public class MenuView extends JPanelWithBackground implements MouseListener {
	private Menuebutton newGame, highScore, options, exitGame;


	ChangeView cv;

	/**
	 * The constructor for the GameView.
	 * 
	 * @param bgpath
	 */
	public MenuView(String bgpath, ChangeView cv) {
		super(bgpath);
		this.cv = cv;
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		this.setSize(1024, 576);
		newGame = new Menuebutton("resources/images/newgame.png");
		highScore = new Menuebutton("resources/images/highscore.png");
		options = new Menuebutton("resources/images/options.png");
		exitGame = new Menuebutton("resources/images/exitgame.png");

		this.add(new Menuebutton("resources/images/menu_logo.gif"));
		this.add(Box.createVerticalGlue());
		this.add(Box.createVerticalGlue());
		this.add(Box.createVerticalGlue());
		this.add(newGame);
		this.add(Box.createVerticalGlue());
		this.add(highScore);
		this.add(Box.createVerticalGlue());
		this.add(options);
		this.add(Box.createVerticalGlue());
		this.add(exitGame);
		
		newGame.addMouseListener(this);
		highScore.addMouseListener(this);
		options.addMouseListener(this);
		exitGame.addMouseListener(this);
	}

	public ChangeView getChangeView() {
		return cv;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == newGame)
			newGame.setIcon(new ImageIcon(
					"resources/images/newgame_onHover.png"));
		if (e.getSource() == highScore)
			highScore.setIcon(new ImageIcon(
					"resources/images/highscore_onHover.png"));
		if (e.getSource() == options)
			options.setIcon(new ImageIcon(
					"resources/images/options_onHover.png"));
		if (e.getSource() == exitGame)
			exitGame.setIcon(new ImageIcon(
					"resources/images/exitgame_onHover.png"));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == newGame)
			newGame.setIcon(new ImageIcon("resources/images/newgame.png"));
		if (e.getSource() == highScore)
			highScore.setIcon(new ImageIcon("resources/images/highscore.png"));
		if (e.getSource() == options)
			options.setIcon(new ImageIcon("resources/images/options.png"));
		if (e.getSource() == exitGame)
			exitGame.setIcon(new ImageIcon("resources/images/exitgame.png"));

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == newGame)
			newGame.setIcon(new ImageIcon(
					"resources/images/newgame_onSelect.png"));
		if (e.getSource() == highScore)
			highScore.setIcon(new ImageIcon(
					"resources/images/highscore_onSelect.png"));
		if (e.getSource() == options)
			options.setIcon(new ImageIcon(
					"resources/images/options_onSelect.png"));
		if (e.getSource() == exitGame)
			exitGame.setIcon(new ImageIcon(
					"resources/images/exitgame_onSelect.png"));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == newGame) {
			newGame.setIcon(new ImageIcon("resources/images/newgame.png"));

			cv.gameView();
		}
		if (e.getSource() == highScore) {
			highScore.setIcon(new ImageIcon("resources/images/highscore.png"));

			cv.highscoreView();
		}
		if (e.getSource() == options) {
			options.setIcon(new ImageIcon("resources/images/options.png"));

			cv.optionView();
		}
		if (e.getSource() == exitGame) {
			exitGame.setIcon(new ImageIcon("resources/images/exitGame.png"));
			System.exit(0);
		}
	}

}
