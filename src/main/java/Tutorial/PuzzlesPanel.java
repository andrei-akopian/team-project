package Tutorial;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class PuzzlesPanel extends JPanel {
    private final PuzzleOpener opener = new PuzzleOpener();
    private final Map<String, List<Puzzle>> puzzles;

    public PuzzlesPanel(Map<String, List<Puzzle>> puzzles){
        this.puzzles = puzzles;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Puzzles", SwingConstants.CENTER);
        JTextArea description = new JTextArea("Train to master the game by solving these puzzles! Find the unique optimal winning sequence of moves for black.");
        description.setEditable(false);
        description.setMaximumSize(description.getPreferredSize());

        JPanel puzzleSelection = new JPanel(new CardLayout());
        puzzleSelection.add(new JPanel(), "Select Level");
        List<String> names = new ArrayList<>();
        names.add("Select Level");
        for (Map.Entry<String, List<Puzzle>> e : puzzles.entrySet()) {
            JPanel level = new JPanel();
            for (Puzzle p : e.getValue()) {
                JButton b = new JButton(p.getName());
                b.addActionListener(ev -> opener.open(p));
                level.add(b);
            }
            puzzleSelection.add(level, e.getKey());
            names.add(e.getKey());
        }

        CardLayout levelCards = (CardLayout) puzzleSelection.getLayout();
        JComboBox<String> levelSelection = new JComboBox<String>(names.toArray(new String[0]));
        levelSelection.addActionListener(e -> {
            String selected = (String) levelSelection.getSelectedItem();
            levelCards.show(puzzleSelection, selected);
        });
        levelSelection.setMaximumSize(levelSelection.getPreferredSize());

        add(title);
        add(description);
        add(Box.createVerticalStrut(10));
        add(levelSelection);
        add(Box.createVerticalStrut(10));
        add(puzzleSelection);
        setBorder(BorderFactory.createEmptyBorder(0, 400, 300, 400));
    }
}