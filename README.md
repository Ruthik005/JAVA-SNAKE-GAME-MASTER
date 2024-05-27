# Java-Snake-Game
# Snake Game

This repository contains the implementation of a classic Snake game in Java, with enhanced features like scoring, high score tracking, pause functionality, and restart capability.

## Features

1. *Score*: Increases by 10 points each time the snake eats an apple.
2. *High Score*: Tracks the highest score achieved during the game session.
3. *Pause*: Allows the player to pause and resume the game.
4. *Restart*: The game can be restarted by pressing the 'R' key after a game over.

## Installation and Running

1. Clone the repository:
    sh
    git clone  (https://github.com/Ruthik005/JAVA-SNAKE-GAME-MASTER.git)
    

3. Navigate to the project directory:
    sh
    cd snake-game
    

4. Open the project in your preferred Java IDE or text editor:
    sh
    code .
    

5. Ensure Java is installed. Download the JDK from [here](https://www.oracle.com/java/technologies/javase-downloads.html).

6. Compile the project:
    sh
    javac -d bin src/com/zetcode/*.java
    

7. Run the project:
    sh
    java -cp bin com.zetcode.Snake
   **** - To run the application in Visual Studio Code, use the shortcut Ctrl+F5. ****

## Usage

- Use the arrow keys to control the snake's direction.
- Press the 'P' key to pause and resume the game.
- Press the 'R' key to restart the game after a game over.

## Design Choices

1. *Separate Initialization*: Improved readability and maintainability by separating board and game state initialization.
2. *Pause Button*: Enhances user experience with easy pausing and resuming.
3. *Restricted Apple Placement*: Ensures apples don't appear over score labels or the pause button.
4. *High Score Persistence*: High scores persist across multiple game sessions within the same runtime.

## Challenges Faced

1. *Apple Placement*: Ensured apples don't overlap with score labels or the pause button.
2. *Pause Functionality*: Implemented smooth toggling between paused and active states.
3. *High Score Tracking*: Ensured accurate high score updates and persistence across sessions.
Java Snake game source code

![image](https://github.com/Ruthik005/JAVA-SNAKE-GAME-MASTER/assets/157978872/f830b9b5-5591-4436-b1bb-35a828df2d05)

 
"# JAVA-SNAKE-GAME-MASTER" 

## Snake Game Documentation
Overview

This document provides detailed information about the implementation of the Snake game, including design choices, challenges faced, and the functionalities added: score, high score, pause, and restart.
Classes

Board.java
The Board class extends JPanel and implements ActionListener. It manages the game logic, rendering, and user inputs.

Fields

•	B_WIDTH: The width of the game board.
•	B_HEIGHT: The height of the game board.
•	DOT_SIZE: The size of each segment of the snake.
•	ALL_DOTS: The maximum number of possible segments (dots) on the board.
•	RAND_POS: The random position limit for the apple.
•	DELAY: The delay for the timer, controlling the game's speed.
•	x[] and y[]: Arrays to store the x and y coordinates of all snake segments.
•	dots: The current number of segments in the snake.
•	apple_x and apple_y: The coordinates of the apple.
•	score: The current score.
•	highScore: The highest score achieved across game sessions.
•	leftDirection, rightDirection, upDirection, downDirection: Booleans to track the direction of the snake's movement.
•	inGame: Boolean to track if the game is running.
•	paused: Boolean to track if the game is paused.
•	timer: Timer to control the game loop.
•	ball, apple, head: Images for the snake segments, apple, and snake's head.
•	pauseButton: Button to pause and resume the game.

Constructor

Board()
•	Initializes the game board by calling initBoard().
Methods
initBoard()
•	Sets up the game board by adding key listeners, setting the background color, and calling loadImages(), initGame(), and addPauseButton().
loadImages()
•	Loads the images for the snake segments, apple, and snake's head from the resources folder.
initGame()
•	Initializes the game state, sets the initial position of the snake, locates the first apple, and starts the timer.
addPauseButton()
•	Adds a pause button to the game board, positioned in the bottom-right corner, and assigns an action listener to toggle the game's paused state.
paintComponent(Graphics g)
•	Calls doDrawing(g) to render the game.
doDrawing(Graphics g)
•	Draws the snake, apple, score, high score, and pause message if the game is paused.
gameOver(Graphics g)
•	Displays the game over message and instructions to restart the game.
checkApple()
•	Checks if the snake's head has collided with the apple. If so, increases the snake's length, updates the score, and relocates the apple.
move()
•	Moves the snake by updating the coordinates of each segment based on the direction of movement.
checkCollision()
•	Checks for collisions with the snake's own body or the walls. If a collision is detected, ends the game.
locateApple()
•	Randomly places the apple on the board, ensuring it does not overlap with the score labels or the pause button.
actionPerformed(ActionEvent e)
•	Invoked by the timer to update the game state, check for apple collisions, and repaint the board if the game is not paused.
TAdapter
•	A nested class extending KeyAdapter to handle keyboard inputs for controlling the snake's direction, pausing, and restarting the game.

Functionalities Added

1. Score
•	The score increases by 10 points each time the snake eats an apple.
•	The score is displayed in the top-left corner of the game board.
2. High Score
•	The high score is the highest score achieved during the game session.
•	The high score is updated if the current score exceeds the previous high score.
•	The high score is displayed below the score in the top-left corner of the game board.
3. Pause
•	A pause button is added to the bottom-right corner of the game board.
•	Pressing the pause button toggles the game's paused state.
•	When paused, the game displays "Game Paused" in the center of the screen and the button text changes to "Resume."
4. Restart
•	Pressing the 'R' key restarts the game if it is over.
•	The game state is reset to its initial conditions.

Design Choices

1.	Separate Method for Initialization:
•	The initialization of the board and game state is handled in separate methods (initBoard() and initGame()) to improve code readability and maintainability.
2.	Pause Button:
•	Adding a pause button enhances the user experience by providing a clear and convenient way to pause and resume the game.
3.	Restrict Apple Placement:
•	The locateApple() method ensures the apple does not appear over the score labels or the pause button, preventing any visual overlap and improving gameplay clarity.
4.	High Score Persistence:
•	Using a static variable for the high score ensures it persists across multiple game sessions within the same runtime.
 
By addressing these challenges and making thoughtful design choices, the game is now more interactive, user-friendly, and visually clear.


