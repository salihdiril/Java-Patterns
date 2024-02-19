package models;

// Concrete Product
public class PresentationDocument implements Document{
	@Override
	public void open() {
		System.out.println("Opening presentation document");
	}

	@Override
	public void save() {
		System.out.println("Saving presentation document");
	}

	@Override
	public void close() {
		System.out.println("Closing presentation document");
	}
}
