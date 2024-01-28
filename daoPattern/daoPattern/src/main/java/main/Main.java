package main;

import java.util.List;

import models.Customer;
import util.JsonParser;

public class Main {
	private static final String customerJsonFilePath = "C:\\Users\\salih.diril\\Documents\\Tutorials\\Java\\Java\\JavaPatterns\\daoPattern\\daoPattern\\src\\main\\resources\\customers.json";
	private static List<Customer> customers = JsonParser.parseFromJsonFile(customerJsonFilePath);

	public static void main(String[] args) {
		System.out.println("customers.size(): " + customers.size());
		System.out.println("customers.get(0): " + customers.get(0).getCreatedAt());
	}
}
