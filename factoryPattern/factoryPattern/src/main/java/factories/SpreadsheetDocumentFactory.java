package factories;

import models.Document;
import models.SpreadsheetDocument;

// Concrete Creator
public class SpreadsheetDocumentFactory implements DocumentFactory{
	@Override
	public Document createDocument() {
		return new SpreadsheetDocument();
	}
}
