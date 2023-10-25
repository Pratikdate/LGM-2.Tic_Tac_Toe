import javax.swing.*;
import java.awt.*;

public class TicTacToeGUI extends JFrame {
    private static final int BOARD_SIZE = 3;
    private JPanel boardPanel;
    private JButton[][] buttons;
    private String currentPlayer = "X";

    public TicTacToeGUI() {

        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        boardPanel.setBackground(new Color(22,0,22));

        buttons = new JButton[BOARD_SIZE][BOARD_SIZE];
        
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                JButton button = new JButton();
                button.setFont(new Font("Arial", Font.PLAIN, 36));

                button.addActionListener(e -> {
                    JButton clickedButton = (JButton) e.getSource();
                    clickedButton.setText(currentPlayer);
                    clickedButton.setEnabled(false);
                    clickedButton.setBackground(new Color(22,0,22));
                    if (checkForWin(currentPlayer)) {
                        JOptionPane.showMessageDialog(TicTacToeGUI.this, "Player " + currentPlayer + " wins!");
                        for (JButton[] buttonRow : buttons) {
                            for (JButton b : buttonRow) {
                                b.setEnabled(false);
                            }
                        }
                    } else {
                        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
                    }
                });

                buttons[row][col] = button;
                boardPanel.add(button);
            }
        }

        getContentPane().add(boardPanel);
        

    }

    private boolean checkForWin(String player) {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (buttons[row][0].getText().equals(player) &&
                    buttons[row][1].getText().equals(player) &&
                    buttons[row][2].getText().equals(player)) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (buttons[0][col].getText().equals(player) &&
                    buttons[1][col].getText().equals(player) &&
                    buttons[2][col].getText().equals(player)) {
                return true;
            }
        }

        // Check diagonals
        if (buttons[0][0].getText().equals(player) &&
                buttons[1][1].getText().equals(player) &&
                buttons[2][2].getText().equals(player)) {
            return true;
        }

        if (buttons[0][2].getText().equals(player) &&
                buttons[1][1].getText().equals(player) &&
                buttons[2][0].getText().equals(player)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        try {

            TicTacToeGUI ticTacToeGUI = new TicTacToeGUI();
            ticTacToeGUI.setTitle("Tic-Tac-Toe");
            ticTacToeGUI.setSize(350, 350);
            ticTacToeGUI.setForeground(Color.white);
            ticTacToeGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ticTacToeGUI.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

}
