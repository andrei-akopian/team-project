# Five In A Row Game
## Team Information
### Team Members
- Andrew Zhang
- Saiesh Rampersad
- Yuehan Gao
- Andrei Akopian
- Jean Huang

---
## Project Description
### Game

Five in a row game, where the goal is to get exactly 5 in a row on a 15x15 board (similar to tic tac toe).

---
## User Stories
### User Story 1: As a player, I want to be able to sign up and create an account and log in to my account to save my game history.
### User Story 2: As a player, I want to see my match history to know how well I am playing and review a move-by-move replay of my past games.
### User Story 3: As a player, I want to be able to play against my friend sitting next to me to spend time with them.
### User Story 4: As a player, I want to be able to play against a computer to have fun and get better at the game.
### User Story 5: As a beginner player, I want to interact with a tutorial to learn how to play the game.
(Add additional user stories as needed.)

---
## Use Cases
### 1. Login/logout/signup and save history
### 2. View match history and replays
Primary actor: player
Preconditions: have games played in the past 
Trigger: player wants to see their past games
Success outcome: previous games are shown to the player
Main Success Scenario: 
- player opens the menu
- the menu loads all the previous games information
- the player clicks on a game to see the replay
- all steps of the game are shown
Extensions:
- if no games are played, nothing is shown
### 3. Playing a game by making moves
Primary actor: player
Preconditions: player is in a game and the game is not over
Trigger: Player wants to make a move
Success outcome: A move is played on the board
Main Success Scenario: 
- Player clicks a cell they wish to make a move on
- It is checked whether this move is allowed, or if the move is a winning move
- a succesful move is relayed back to the player
- The turn is then switched to the other player
Extensions:
- if the move is not allowed, nothing happens and the player can try again
- if the move is a winning move, the player is told they won and they can no longer do anything
### 4. Play against Computer player making a move
Primary actor: player
Preconditions: player is in a game against a computer and the game is not over
Trigger: Player finishes making a move
Success outcome: A move is played by the computer
Main Success Scenario: 
- player finishes making their move
- the computer decides on a move to make
- the move is relayed back to the player
- The turn is then switched to the player
Extensions:
- if the move is a winning move, the player is told they lost and they can no longer do anything
### 5. Use Tutorial

(Add additional use cases as needed.)

---
## Minimal Viable Product (MVP)
| Team Member | MVP Use Case |
|-------------|--------------|
| Andrew      | 3            |
| Andrei      | 4            |
| Saiesh      | 5            |
| Yuehan      | 2.           |
| Jean        | 1.           |

---
## Entities
### Game (handles game logic, such as whos turn it is, and manages the board)
Instance Variables:
- private int turn
- private Board board
Methods:
- public Game()
- public void playerInput(Move move)
- public void flipTurn()
- public Move undo()
- public int getTurn()
- public int getWinner()
- public board getBoard()

### Board (handles game logic, such as checking for wins)
Instance Variables:
- public final int BOARD_SIZE
- public final int WIN_THRESHOLD
- private int[][] boardState
- private int winner
- private ArrayList<Move> moves
Methods:
- public Board()
- public boolean inBounds()
- public int getWinner()
- public int getTile(int row, int column)
- public boolean tileIsEmpty(int row, int column)
- public boolean tileIsEmpty(Move move)
- public boolean makeMove(Move move, int player)
- public boolean checkWin(int row, int column, int player)
- public boolean checkDirection(int row, int column, int dx, int dy, int player)
- public Move undo()
- public ArrayList<Move> getMoveHistory()
- public Board copy()
### Puzzle (contains information which defines the setup and solution of a puzzle for the tutorial)
(Add additional entities as needed.)

---
## API Usage
**API Name:**
**Documentation:** [Link]
**How it is used in the program:**

---
## How to Run
[Instructions for running the program.]

```
mvn install
```

