package main;

import factory.AnimalCompanion;
import models.Animal;

public class Client {
	public static void main(String[] args) {
		Animal dog = AnimalCompanion.createDog();
		Animal cat = AnimalCompanion.createCat();
		Animal bird = AnimalCompanion.createBird();

		dog.call();
		cat.call();
		bird.call();
	}
}
