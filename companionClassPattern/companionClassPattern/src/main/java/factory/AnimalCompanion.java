package factory;

import models.Animal;
import models.Bird;
import models.Cat;
import models.Dog;

public class AnimalCompanion {
	private AnimalCompanion() {
	}

	public static Animal createDog() {
		return new Dog();
	}

	public static Animal createCat() {
		return new Cat();
	}

	public static Animal createBird() {
		return new Bird();
	}
}
