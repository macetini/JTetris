package data;

import java.awt.Point;

public class MovingPieceData {

	private Point position;
	private int[][][] shapes;
	private int rotationIndex = 0;
	private int colorIndex = 0;

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
		for (int i = 0; i < shapes.length; i++) {
			for (int j = 0; j < shapes[i].length; j++) {
				for (int k = 0; k < shapes[i][j].length; k++) {
					int cellData = shapes[i][j][k];
					if (cellData != 0) {
						shapes[i][j][k] = colorIndex + 1;
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

	public MovingPieceData clone() {
		MovingPieceData clone = new MovingPieceData();

		Point point = new Point();
		point.x = position.x;
		point.y = position.y;

		clone.setPosition(point);
		clone.setShapes(shapes);

		clone.rotationIndex = rotationIndex;

		return clone;
	}
}