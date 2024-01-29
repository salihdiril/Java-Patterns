package main;

import java.util.List;

import com.hazelcast.map.IMap;
import models.Constants;
import models.Customer;
import util.HazelcastDaoUtil;
import util.JsonParser;

public class Main {
	private static final String customerJsonFilePath = Constants.CUSTOMER_JSON_FILE_PATH;
	private static List<Customer> customers = JsonParser.parseFromJsonFile(customerJsonFilePath);

	public static void main(String[] args) {
		HazelcastDaoUtil.putCustomerObjectToHazelcast(customers);
		IMap<Integer, Customer> hazelcastCustomerMap = HazelcastDaoUtil.getCustomerMapFromHazelcast(Constants.HAZELCAST_CUSTOMER_MAP_NAME);
		hazelcastCustomerMap.entrySet().stream().forEach(
				entry -> System.out.println("entry.getKey(): " + entry.getKey() + " entry.getValue().toString(): " + entry.getValue().toString()));
		HazelcastDaoUtil.shutdownHazelcastInstance();
	}
}
