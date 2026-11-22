package Tutorial;

import javax.swing.*;

public class Main {
    static void main() {
        SwingUtilities.invokeLater(() -> new TutorialView(new PuzzlesData().getPuzzles()));
    }
}