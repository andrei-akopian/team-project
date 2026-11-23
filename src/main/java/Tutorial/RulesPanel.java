package Tutorial;

import javax.swing.*;
import java.awt.*;

public class RulesPanel extends JPanel {

    public RulesPanel() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Rules", SwingConstants.CENTER);
        JTextArea rules = new JTextArea(
                """
                        1. Two players take turns placing one stone at a time on the squares of a 15x15 board.
                        2. Player 1 begins with the black stones, followed by Player 2 with white stones.
                        3. To win, a player must create at least one line of exactly 5 consecutive stones of\
                         that colour horizontally, vertically or diagonally.
                        4. In particular, if placing a stone only creates lines of 6-7 stones,\
                         then this does not count as a winning move.
                        5. Have fun!"""
        );

        rules.setEditable(false);
        add(title, BorderLayout.NORTH);
        add(rules, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20, 400, 50, 400));
    }
}