package Tutorial;


import javax.swing.*;
import java.awt.*;

public class TutorialView extends JFrame{

    public TutorialView(){
        TutorialInteractor interactor = new TutorialInteractor();
        setLayout(new BorderLayout());
        setTitle("Tutorial");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 800);
        add(new RulesPanel(), BorderLayout.NORTH);
        add(new PuzzlesPanel(interactor), BorderLayout.CENTER);
        setVisible(true);
    }

    static void main() {
        SwingUtilities.invokeLater(TutorialView::new);
    }
}