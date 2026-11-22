package Tutorial;

import javax.swing.*;

public class Main {
    static void main(String[] args) {
        PuzzlesAccessInterface puzzles = new PuzzlesData();
        SwingUtilities.invokeLater(() -> new TutorialView(puzzles.getPuzzles()));
    }
}