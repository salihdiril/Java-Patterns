package factory;

import java.awt.*;

import models.Circle;
import models.Shape;
import models.Square;

// Flyweight Factory manages a pool of Flyweight objects
public class ShapeFactory {
	private static final String CIRCLE_KEY = "circle";
	private static final String SQUARE_KEY = "square";
	private static final Shape circle = new Circle(5, Color.RED);
	private static final Shape square = new Square(5, Color.BLUE);

	public static Shape getShape(String type) {
		switch (type) {
		case CIRCLE_KEY:
			return circle;
		case SQUARE_KEY:
			return square;
		default:
			throw new IllegalArgumentException("Unsupported shape type: " + type);
		}
	}
}
