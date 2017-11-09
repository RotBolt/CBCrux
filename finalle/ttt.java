
package finalle;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ttt extends JFrame implements ActionListener {
	private static final int BOARD_SIZE = 3;

	private JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE];

	public static enum gamestatus {
		Xwins, Zwins, TIE, Incomplete
	}

	private boolean crossturn = true;

	ttt() {

		super.setTitle("Zero Katta a.k.a Tic Tac Toe");

		super.setSize(800, 800);

		GridLayout grid = new GridLayout(BOARD_SIZE, BOARD_SIZE);

		super.setLayout(grid);

		Font font = new Font("Comic Sans", 1, 150);

		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				JButton button = new JButton("");
				buttons[row][col] = button;

				buttons[row][col].setBackground(new Color(16, 0, 23));
				button.addActionListener(this);
				button.setFont(font);
				super.add(button);
			}
		}
		super.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		JButton clickedbutton = (JButton) e.getSource();
		this.makemove(clickedbutton);
		gamestatus gs = this.getgameStats();
		if (gs.equals(gamestatus.Incomplete)) {
			return;
		}
		declarewin(gs);
		int choice = JOptionPane.showConfirmDialog(this, "Would like to restart");
		if (choice == JOptionPane.YES_OPTION) {
			for (int i = 0; i < BOARD_SIZE; i++) {
				for (int j = 0; j < BOARD_SIZE; j++) {
					buttons[i][j].setText("");
				}
			}
			crossturn = true;
		} else {
			super.dispose();
		}
	}

	private void makemove(JButton clickedbutton) {
		String btntext = clickedbutton.getText();
		if (btntext.length() > 0) {
			JOptionPane message = new JOptionPane();
			message.showMessageDialog(this, "Invalid move");
			return;
		}
		if (crossturn) {
			clickedbutton.setText("O");
		} else {
			clickedbutton.setText("X");
		}
		crossturn = !crossturn;

		return;

	}

	private gamestatus getgameStats() {
		String str1 = " ";
		String str2 = " ";
		int row = 0, col = 0;

		// for rows
		for (row = 0; row < BOARD_SIZE; row++) {
			for (col = 0; col < BOARD_SIZE - 1; col++) {
				str1 = buttons[row][col].getText();
				str2 = buttons[row][col + 1].getText();
				if (!str1.equals(str2) || str1.length() == 0 || str2.length() == 0) {
					break;
				}
			}
			if (col == BOARD_SIZE - 1) {
				String win = buttons[row][col].getText();
				if (win.equals("X")) {
					return gamestatus.Xwins;
				} else if (win.equals("O")) {
					return gamestatus.Zwins;
				}
			}
		}

		// for cols
		for (col = 0; col < BOARD_SIZE; col++) {
			for (row = 0; row < BOARD_SIZE - 1; row++) {
				str1 = buttons[row][col].getText();
				str2 = buttons[row + 1][col].getText();
				if (!str1.equals(str2) || str1.length() == 0 || str2.length() == 0) {
					break;
				}
			}
			if (row == BOARD_SIZE - 1) {
				String win = buttons[row][col].getText();
				if (win.equals("X")) {
					return gamestatus.Xwins;
				} else if (win.equals("O")) {
					return gamestatus.Zwins;
				}
			}
		}

		// for diagnol
		for (row = 0, col = 0; row < BOARD_SIZE - 1; row++, col++) {
			str1 = buttons[row][col].getText();
			str2 = buttons[row + 1][col + 1].getText();
			if (!str1.equals(str2) || str1.length() == 0 || str2.length() == 0) {
				break;
			}
		}
		if (row == BOARD_SIZE - 1) {
			String win = buttons[row][col].getText();
			if (win.equals("X")) {
				return gamestatus.Xwins;
			} else if (win.equals("O")) {
				return gamestatus.Zwins;
			}
		}

		// for second diagnol
		for (row = 0, col = BOARD_SIZE - 1; row < BOARD_SIZE - 1; row++) {
			str1 = buttons[row][col - row].getText();
			str2 = buttons[row + 1][col - (row + 1)].getText();
			if (!str1.equals(str2) || str1.length() == 0 || str2.length() == 0) {
				break;
			}
		}
		if (row == BOARD_SIZE - 1) {
			String win = buttons[row][0].getText();
			if (win.equals("X")) {
				return gamestatus.Xwins;
			} else if (win.equals("O")) {
				return gamestatus.Zwins;
			}
		}
		// for incomplete and tie
		for (row = 0; row < BOARD_SIZE; row++) {
			for (col = 0; col < BOARD_SIZE; col++) {
				String text = buttons[row][col].getText();
				if (text.length() == 0) {
					return gamestatus.Incomplete;
				}
			}
		}
		return gamestatus.TIE;
	}

	private void declarewin(gamestatus gs) {
		if (gs.equals(gamestatus.Xwins)) {
			JOptionPane.showMessageDialog(this, "X Wins");
		} else if (gs.equals(gamestatus.Zwins)) {
			JOptionPane.showMessageDialog(this, "Z Wins");
		} else {
			JOptionPane.showMessageDialog(this, "Tie");
		}
	}
}
