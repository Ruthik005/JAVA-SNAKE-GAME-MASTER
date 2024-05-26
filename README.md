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
    git clone https://github.com/your-username/snake-game.git
    

2. Navigate to the project directory:
    sh
    cd snake-game
    

3. Open the project in your preferred Java IDE or text editor:
    sh
    code .
    

4. Ensure Java is installed. Download the JDK from [here](https://www.oracle.com/java/technologies/javase-downloads.html).

5. Compile the project:
    sh
    javac -d bin src/com/zetcode/*.java
    

6. Run the project:
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
