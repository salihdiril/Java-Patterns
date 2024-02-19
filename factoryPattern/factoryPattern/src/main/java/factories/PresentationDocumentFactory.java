package factories;

import models.Document;
import models.PresentationDocument;

// Concrete Creator
public class PresentationDocumentFactory implements DocumentFactory{
	@Override
	public Document createDocument() {
		return new PresentationDocument();
	}
}
