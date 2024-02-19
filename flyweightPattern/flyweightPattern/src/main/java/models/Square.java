package models;

import java.awt.*;

// Concrete Flyweight representing a square
public class Square implements Shape{
	private final int sideLength;
	private final Color color;

	public Square(int sideLength, Color color) {
		this.sideLength = sideLength;
		this.color = color;
	}

	@Override
	public void draw(int x, int y) {
		System.out.println("Drawing square with side length " + sideLength + " at position (" + x + ", " + y + ") with color " + color);
	}
}
