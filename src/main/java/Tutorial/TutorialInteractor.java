package Tutorial;

public class TutorialInteractor {
    private PuzzlesAccessInterface puzzles;
    private TutorialInputBoundary presenter;
    public void execute(String name){
       Puzzle puzzle = puzzles.getPuzzle(name);
       //presenter.prepareView(puzzle);
    }

}
