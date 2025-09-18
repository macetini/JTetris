# JTetris

A simple, bare-bones Tetris game written in Java 8 using Swing for the GUI.  
Originally created as a high school project and later modernized for Java 8.
=======
# Java 8 Tetris

Found an old floppy disk at my parents' with a Java project from high school.

I modernized it to Java 8. A simple, bare-bones Java. Swing for GUI and no additional external libraries. 

![Tetris Screenshot](https://github.com/user-attachments/assets/6442ac89-50ba-44cd-9992-8407dcb99e1c)

## Features

- Classic Tetris gameplay
- Responsive keyboard controls
- Clean and minimalistic Swing-based interface
- No external dependencies

## Requirements

- Java 8 or newer

## How to Run

1. Clone or download the repository.
2. Compile the source code:
   ```
   javac -d bin src/game/Main.java
   ```
3. Run the game:
   ```
   java -cp bin game.Main
   ```

## Controls

- **Left/Right Arrow:** Move tetromino left/right
- **Up Arrow:** Rotate tetromino
- **Down Arrow:** Soft drop
- **Escape:** Quit game

## Project Structure

- `src/game/` - Main entry point and game logic
- `src/game/gui/` - GUI components (Swing)
- `src/game/data/` - Data models for grid and pieces
- `src/game/meta/` - Configuration and constants
- `src/game/util/` - Utility classes

## License

This project is provided for educational purposes.  
Feel free to use, modify, or share.

---
