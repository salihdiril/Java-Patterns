package factories;

import models.Document;
import models.TextDocument;

// Concrete Creator
public class TextDocumentFactory implements DocumentFactory{
	@Override
	public Document createDocument() {
		return new TextDocument();
	}
}
