package main;

import factory.ShapeFactory;
import models.Shape;

// Client Code
public class Client {
	public static void main(String[] args) {
		// Render shapes using shared Flyweight objects
		renderShape("circle", 10, 10);
		renderShape("square", 20, 20);
		renderShape("circle", 30, 30);
		renderShape("square", 40, 40);
		renderShape("circle", 50, 50);
	}

	public static void renderShape(String type, int x, int y) {
		Shape shape = ShapeFactory.getShape(type);
		shape.draw(x, y);
	}
}
