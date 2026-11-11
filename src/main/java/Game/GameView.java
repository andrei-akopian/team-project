package Game;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GameView extends JFrame {
    private final int BOARD_SIZE = AppConfig.getInt("board_size");
    private JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE];
    private JPanel board;
    private GameController gameController;

    public GameView() {
        gameController = null;
        setTitle("Five in a Row");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        populateBoardButtons();
        board.setPreferredSize(new Dimension(800, 800));

        JPanel container = new JPanel(new GridBagLayout());

        container.add(board);

        add(container);

        pack();
        setSize(1000,1000);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void populateBoardButtons () {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                JButton button = new JButton();
                buttons[row][col] = button;

                final int r = row;
                final int c = col;

                button.addActionListener(e -> {
                    if (gameController != null) {
                        gameController.execute(r, c);
                    }
                });

                button.setBackground(new Color(255, 228, 163));
                button.setOpaque(true);
                button.setContentAreaFilled(true);
                button.setBorder(new LineBorder(Color.GRAY, 1));

                board.add(button);
            }
        }
    }

    public void updateBoard(GameViewModel viewModel) {

        int row = viewModel.getRow();
        int col = viewModel.getColumn();
        int player = viewModel.getPlayer();
        int winner = viewModel.getWinner();

        if (player == 1) {
            buttons[row][col].setBackground(Color.BLACK);
        } else if (player == 2) {
            buttons[row][col].setBackground(Color.WHITE);
        }

        buttons[row][col].setOpaque(true);
        buttons[row][col].setEnabled(false);

        if (winner != 0){
            System.out.println(winner);
            for (JButton[] buttons1:buttons){
                for (JButton button: buttons1){
                    button.setEnabled(false);
                }
            }
        }
    }

    public void setController(GameController gameController){
        this.gameController = gameController;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            GameView view = new GameView();
            GamePresenter presenter = new GamePresenter(view);
            GameInteractor interactor = new GameInteractor(presenter);
            GameController controller = new GameController(interactor);
            view.setController(controller);
            view.setVisible(true);
        });
    }
}
