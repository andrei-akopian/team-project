package Tutorial;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.util.List;
import java.util.Map;

public class TutorialView extends JFrame {

    public TutorialView(Map<String, List<Puzzle>> puzzles) {
        setLayout(new BorderLayout());
        setTitle("Tutorial");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 800);
        add(new RulesPanel(), BorderLayout.NORTH);
        add(new PuzzlesPanel(puzzles), BorderLayout.CENTER);
        setVisible(true);
    }
}