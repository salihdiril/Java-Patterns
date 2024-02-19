package main;

import java.util.Locale;
import java.util.Scanner;

import factories.DocumentFactory;
import factories.PresentationDocumentFactory;
import factories.SpreadsheetDocumentFactory;
import factories.TextDocumentFactory;
import models.Document;
import utils.DocumentTypes;

// Client Code
public class Client {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type the document you want to create between text, spreadsheet, and presentation: ");
		String documentType = scanner.nextLine().toLowerCase();

		DocumentFactory factory;

		switch (documentType) {
		case DocumentTypes.TEXT:
			factory = new TextDocumentFactory();
			break;
		case DocumentTypes.SPREADSHEET:
			factory = new SpreadsheetDocumentFactory();
			break;
		case DocumentTypes.PRESENTATION:
			factory = new PresentationDocumentFactory();
			break;
		default:
			throw new IllegalArgumentException("unknown document type!!!");
		}

		Document document = factory.createDocument();

		document.open();
		document.save();
		document.close();
	}
}
