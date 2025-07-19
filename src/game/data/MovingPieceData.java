package game.data;

import java.awt.Point;

public class MovingPieceData {

	private Point position;
	private int[][][] shapes;
	private int rotationIndex = 0;
	private int colorIndex = 0;

	public MovingPieceData() {
	}

	public MovingPieceData(MovingPieceData original) {
		position = (Point) original.position.clone();
		shapes = original.shapes;
		rotationIndex = original.rotationIndex;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public int[][] getShape() {
		return shapes[rotationIndex];
	}

	public void setShapes(int[][][] shape) {
		this.shapes = shape;
	}

	public int getRotation() {
		return rotationIndex;
	}

	public int getColorIndex() {
		return colorIndex;
	}

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

	public void rotatate() {
		rotationIndex = (++rotationIndex) % shapes.length;
	}

	public void moveDown() {
		position.y++;
	}

	public boolean isIdentical(MovingPieceData other) {
		return other.getPosition().y == this.getPosition().y && other.getPosition().x == this.getPosition().x
				&& other.getRotation() == this.getRotation();
	}
}