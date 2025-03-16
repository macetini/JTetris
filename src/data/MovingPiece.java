package data;

import java.awt.Point;

public class MovingPiece {

	private Point position;
	private int[][][] shapes;
	private int rotationIndex = 0;

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

	public void rotatate() {
		rotationIndex = (++rotationIndex) % shapes.length;		
	}

	public void moveDown() {
		position.y++;
	}

	public boolean identical(MovingPiece other) {

		return other.getPosition().y == getPosition().y && other.getPosition().x == getPosition().x
				&& other.getRotation() == getRotation();

	}

	public MovingPiece clone() {
		MovingPiece clone = new MovingPiece();

		Point point = new Point();
		point.x = position.x;
		point.y = position.y;

		clone.setPosition(point);
		clone.setShapes(shapes);

		clone.rotationIndex = rotationIndex;

		return clone;
	}

}
