package models;

import java.awt.*;

// Concrete Flyweight representing a circle
public class Circle implements Shape{
	private final int radius;
	private final Color color;

	public Circle(int radius, Color color) {
		this.radius = radius;
		this.color = color;
	}

	@Override
	public void draw(int x, int y) {
		System.out.println("Drawing circle with radius " + radius + " at position (" + x + ", " + y + ") with color " + color);
	}
}
