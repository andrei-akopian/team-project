package Tutorial;

import javax.swing.*;
import java.awt.*;

public class PuzzlesPanel extends JPanel {
    private TutorialInteractor interactor;

    public PuzzlesPanel(TutorialInteractor interactor){
        this.interactor = interactor;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Puzzles", SwingConstants.CENTER);
        JTextArea description = new JTextArea("Train to master the game by solving these puzzles! Find the unique optimal winning sequence of moves for black.");
        description.setEditable(false);
        description.setMaximumSize(description.getPreferredSize());

        JPanel puzzles = new JPanel(new CardLayout());
        JPanel DefaultPanel = new JPanel();
        JPanel BegPanel = new JPanel();
        JPanel IntPanel = new JPanel();
        JPanel AdvPanel = new JPanel();
        JButton b1 = new JButton("Getting started");
        b1.addActionListener(e -> {
            interactor.execute(b1.getName());
        });
        BegPanel.add(b1);
        puzzles.add(DefaultPanel, "Select Level");
        puzzles.add(BegPanel, "Beginner");
        puzzles.add(IntPanel, "Intermediate");
        puzzles.add(AdvPanel, "Advanced");
        CardLayout levelCards = (CardLayout) puzzles.getLayout();

        JComboBox<String> levels = new JComboBox<String>(new String[]{"Select Level", "Beginner", "Intermediate", "Advanced"});
        levels.addActionListener(e -> {
            String selected = (String) levels.getSelectedItem();
            levelCards.show(puzzles, selected);
        });
        levels.setMaximumSize(levels.getPreferredSize());

        add(title);
        add(description);
        add(Box.createVerticalStrut(10));
        add(levels);
        add(Box.createVerticalStrut(10));
        add(puzzles);
        setBorder(BorderFactory.createEmptyBorder(0, 400, 300, 400));
    }
    // puzzles: panel of buttons which link to puzzle boards
    // levels: dropdown to choose level
}