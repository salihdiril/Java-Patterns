package util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Customer;

public class JsonParser {

	private JsonParser () {

	}
	public static List<Customer> parseFromJsonFile(String path) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			// Read JSON data from a file and parse it into a JsonNode
			JsonNode jsonNode = objectMapper.readTree(new File(path));

			// Deserialize JsonNode into a list of Customers and return
			return objectMapper.convertValue(jsonNode, new TypeReference<>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return List.of();
	}
}
