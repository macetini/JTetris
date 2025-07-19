package game.logic;

import java.awt.Point;

import game.data.MovingPieceData;
import game.meta.Config;

/**
 * Utility class for collision detection in the Tetris game.
 * Provides methods to check for collisions with the grid, floor, and walls.
 */
public class Collision {

    /**
     * Checks if the given piece collides with any filled cell in the grid data.
     *
     * @param newPiece the moving piece to check
     * @param data the current grid data
     * @return true if a collision with grid data occurs, false otherwise
     */
    public boolean collidesWithGridData(MovingPieceData newPiece, int[][] data) {
        Point newPosition = newPiece.getPosition();
        int[][] currentShape = newPiece.getShape();

        for (int i = 0; i < currentShape.length; i++) {
            for (int j = 0; j < currentShape[i].length; j++) {
                if (currentShape[i][j] != 0) {
                    int cellData = data[newPosition.y + i][newPosition.x + j];
                    if (cellData != 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if the given piece collides with the bottom of the grid (the floor).
     *
     * @param newPiece the moving piece to check
     * @return true if a collision with the floor occurs, false otherwise
     */
    public boolean collidesWithFloor(MovingPieceData newPiece) {
        Point newPosition = newPiece.getPosition();
        int[][] currentShape = newPiece.getShape();

        for (int i = 0; i < currentShape.length; i++) {
            for (int j = 0; j < currentShape[i].length; j++) {
                int cellData = currentShape[i][j];
                if (cellData != 0) {
                    int shapePiecePosition = newPosition.y + i;
                    if (shapePiecePosition >= Config.ROWS) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks for a vertical collision (with the floor or grid data).
     *
     * @param newPiece the moving piece to check
     * @param data the current grid data
     * @return true if a vertical collision occurs, false otherwise
     */
    public boolean checkVerticalCoalision(MovingPieceData newPiece, int[][] data) {
        return (collidesWithFloor(newPiece) || collidesWithGridData(newPiece, data));
    }

    /**
     * Checks if the given piece collides with the left or right wall of the grid.
     *
     * @param newPiece the moving piece to check
     * @return true if a collision with a wall occurs, false otherwise
     */
    public boolean collidesWithWall(MovingPieceData newPiece) {
        Point newPosition = newPiece.getPosition();
        int[][] currentShape = newPiece.getShape();

        for (int[] collums : currentShape) {
            int wallOffset = 0;
            for (int cellData : collums) {
                if (cellData != 0) {
                    int shapePiecePosition = newPosition.x + wallOffset;
                    if (shapePiecePosition < 0 || shapePiecePosition >= Config.COLUMNS) {
                        return true;
                    }
                }
                wallOffset++;
            }
        }
        return false;
    }

    /**
     * Checks for a horizontal collision (with the wall or grid data).
     *
     * @param newPiece the moving piece to check
     * @param data the current grid data
     * @return true if a horizontal collision occurs, false otherwise
     */
    public boolean checkHorizontalCoalision(MovingPieceData newPiece, int[][] data) {
        return (collidesWithWall(newPiece) || collidesWithGridData(newPiece, data));
    }
}
