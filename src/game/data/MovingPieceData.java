package game.data;

import java.awt.Point;

/**
 * Represents a moving tetromino piece in the Tetris game,
 * including its position, shape, rotation, and color.
 */
public class MovingPieceData {

	/** The current position of the piece on the grid. */
	private Point position;
	/** The array of shapes representing all rotation states of the piece. */
	private int[][][] shapes;
	/** The current rotation index. */
	private int rotationIndex = 0;
	/** The color index of the piece. */
	private int colorIndex = 0;

	/**
	 * Constructs a new MovingPieceData instance.
	 */
	public MovingPieceData() {
	}

	/**
	 * Copy constructor. Creates a new MovingPieceData from an existing one.
	 *
	 * @param original the MovingPieceData to copy
	 */
	public MovingPieceData(MovingPieceData original) {
		position = (Point) original.position.clone();
		shapes = original.shapes;
		rotationIndex = original.rotationIndex;
	}

	/**
	 * Gets the current position of the piece.
	 *
	 * @return the position as a {@link Point}
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Sets the position of the piece.
	 *
	 * @param position the new position as a {@link Point}
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * Gets the current shape of the piece based on its rotation.
	 *
	 * @return a 2D array representing the current shape
	 */
	public int[][] getShape() {
		return shapes[rotationIndex];
	}

	/**
	 * Sets the shapes (all rotation states) for this piece.
	 *
	 * @param shape a 3D array of all rotation states
	 */
	public void setShapes(int[][][] shape) {
		this.shapes = shape;
	}

	/**
	 * Gets the current rotation index.
	 *
	 * @return the rotation index
	 */
	public int getRotation() {
		return rotationIndex;
	}

	/**
	 * Gets the color index of the piece.
	 *
	 * @return the color index
	 */
	public int getColorIndex() {
		return colorIndex;
	}

	/**
	 * Sets the color index for the piece and updates all non-zero cells in all
	 * rotations.
	 *
	 * @param colorIndex the color index to set
	 */
	public void setColor(int colorIndex) {
		this.colorIndex = colorIndex;

		for (int[][] rows : shapes) {
			for (int[] collums : rows) {
				for (int i = 0; i < collums.length; i++) {
					int cellData = collums[i];
					if (cellData != 0) {
						collums[i] = colorIndex + 1;
					}
				}
			}
		}
	}

	/**
	 * Rotates the piece to the next rotation state.
	 */
	public void rotatate() {
		rotationIndex = (++rotationIndex) % shapes.length;
	}

	/**
	 * Moves the piece down by one row.
	 */
	public void moveDown() {
		position.y++;
	}

	/**
	 * Checks if this piece is identical in position and rotation to another piece.
	 *
	 * @param other the other MovingPieceData to compare
	 * @return true if both pieces have the same position and rotation, false
	 *         otherwise
	 */
	public boolean isIdentical(MovingPieceData other) {
		return other.getPosition().y == this.getPosition().y && other.getPosition().x == this.getPosition().x
				&& other.getRotation() == this.getRotation();
	}
}