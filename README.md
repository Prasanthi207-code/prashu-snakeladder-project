# Snake and Ladder Game

A console-based Java implementation of the classic **Snake and Ladder** board game that demonstrates core Java programming concepts and problem-solving techniques.

## Overview

This project simulates the traditional Snake and Ladder game where players race to reach the end of a 100-square board. Players take turns rolling a dice, moving their tokens, and navigating snakes (which send them backward) and ladders (which send them forward). The first player to reach or exceed square 100 wins the game.

## Features

- **Dice Rolling**: Simulates random dice rolls (1-6)
- **Player Movement**: Handles player token movement across the board
- **Snakes & Ladders**: Implements snake and ladder mechanics for board interactions
- **Exact Win Condition**: Enforces the exact-win rule for reaching the finish
- **Multiple Players**: Supports multiple players in a single game
- **Console-Based Interface**: Interactive text-based gameplay

## Technical Details

### Data Structures & Concepts Used

- **HashMap**: Used to store snake and ladder positions for efficient lookup
- **Random**: Generates random dice rolls
- **Loops**: Controls game flow and turn-based mechanics
- **Conditional Statements**: Determines game logic and player actions

### Core Java Concepts Demonstrated

- Object-Oriented Programming (OOP)
- Data structure implementation
- Algorithm design
- User input handling
- Game state management

## Project Structure

```
prashu-snakeladder-project/
├── src/
│   └── SnakeLadder.java     # Main game logic and implementation
├── README.md                # This file
└── ...
```

## How to Play

1. **Compile the Java program**:
   ```bash
   javac src/SnakeLadder.java
   ```

2. **Run the game**:
   ```bash
   java -cp src SnakeLadder
   ```

3. **Follow the on-screen prompts**:
   - Enter the number of players
   - Players take turns rolling the dice
   - Navigate the board, encountering snakes and ladders
   - First player to reach square 100 wins!

## Game Rules

- Players start at square 0
- On each turn, a player rolls a dice (1-6)
- Move your token forward by the number shown on the dice
- If you land on a **ladder**, climb up to a higher square
- If you land on a **snake**, slide down to a lower square
- You must reach exactly square 100 to win
- If your move would take you beyond square 100, you cannot move (exact-win condition)

## Learning Outcomes

This project helps developers understand:

- How to design and implement a game using Java
- Effective use of data structures (HashMap)
- Working with randomness in Java
- Implementing game logic with loops and conditionals
- Managing game state and player turns
- Building interactive console applications

## Requirements

- Java 8 or higher
- No external dependencies

## Author

Created by Prasanthi207-code

## License

This project is provided as-is for educational purposes.
