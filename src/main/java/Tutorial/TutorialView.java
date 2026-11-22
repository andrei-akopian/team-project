package Tutorial;


import Game.GameView;
import Game.GameViewModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class TutorialView extends JFrame{

    public TutorialView(Map<String, List<Puzzle>> puzzles){
        GameView puzzlesView = new GameView(new GameViewModel());
        puzzlesView.setVisible(false);
        setLayout(new BorderLayout());
        setTitle("Tutorial");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 800);
        add(new RulesPanel(), BorderLayout.NORTH);
        add(new PuzzlesPanel(puzzles), BorderLayout.CENTER);
        setVisible(true);
    }

    static void main() {
        //SwingUtilities.invokeLater(TutorialView::new);
    }
}