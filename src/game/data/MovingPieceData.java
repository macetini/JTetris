package game.data;

import java.awt.Point;
import java.util.Arrays;

/**
 * Represents a moving tetromino piece in the Tetris game, including its
 * position, shape, rotation, and color.
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
	 * * @param original the MovingPieceData to copy
	 */
	public MovingPieceData(MovingPieceData original) { //
		this.position = (Point) original.position.clone();
		this.shapes = original.shapes;
		this.rotationIndex = original.rotationIndex;
		this.colorIndex = original.colorIndex;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * Gets the current shape of the piece based on its rotation.
	 *
	 * @return a 2D array representing the current shape
	 */
	public int[][] getShape() {
		// FIX: Added null check for robustness
		return shapes != null ? shapes[rotationIndex] : null;
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
	 * Sets the current rotation index. * @param rotationIndex the new rotation
	 * index
	 */
	public void setRotationIndex(int rotationIndex) {
		this.rotationIndex = rotationIndex;
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
	 * Sets the shapes (all rotation states) for this piece. Performs a DEEP COPY of
	 * the 3D shape array to ensure that modifying the shape's cells (in setColor)
	 * does not affect the static shape definitions.
	 *
	 * @param shape a 3D array of all rotation states
	 */
	public void setShapes(int[][][] shape) {
		// Deep copy the 3D array
		this.shapes = new int[shape.length][][];

		for (int i = 0; i < shape.length; i++) {
			int[][] rotation = shape[i];
			this.shapes[i] = new int[rotation.length][];
			for (int j = 0; j < rotation.length; j++) {
				this.shapes[i][j] = Arrays.copyOf(rotation[j], rotation[j].length);
			}
		}
	}

	/**
	 * Sets the color index for the piece and updates all non-zero cells in all
	 * rotations. * FIX: This operation is now safe because setShapes performs a
	 * deep copy.
	 *
	 * @param colorIndex the color index to set
	 */
	public void setColor(int colorIndex) {
		this.colorIndex = colorIndex;

		if (shapes == null) {
			return; // Guard against null shapes
		}

		for (int[][] rows : shapes) {
			for (int[] columns : rows) {
				for (int i = 0; i < columns.length; i++) {
					int cellData = columns[i];
					if (cellData != 0) {
						// NOTE: The convention is colorIndex + 1 because 0 is typically 'empty'
						columns[i] = colorIndex + 1;
					}
				}
			}
		}
	}

	/**
	 * Rotates the piece to the next rotation state.
	 */
	public void rotate() {
		// Null check
		if (shapes != null) {
			rotationIndex = (++rotationIndex) % shapes.length;
		}
	}

	/**
	 * Moves the piece down by one row.
	 */
	public void moveDown() {
		// Ensure position is not null
		if (position != null) {
			position.y++;
		}
	}

	/**
	 * Checks if this piece is identical in position and rotation to another piece.
	 *
	 * @param other the other MovingPieceData to compare
	 * @return true if both pieces have the same position and rotation, false
	 *         otherwise
	 */
	public boolean isIdentical(MovingPieceData other) {
		// Null checks for safety
		if (other == null || this.position == null || other.position == null) {
			return false;
		}

		return other.getPosition().y == this.position.y && other.getPosition().x == this.position.x
				&& other.getRotation() == this.rotationIndex;
	}
}