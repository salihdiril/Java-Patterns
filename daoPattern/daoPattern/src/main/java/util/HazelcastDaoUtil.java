package util;

import java.util.List;

import com.hazelcast.config.Config;
import com.hazelcast.map.IMap;
import dao.HazelcastCustomerDaoImpl;
import models.Customer;

public class HazelcastDaoUtil {
	// we can use native serializer of Hazelcast for optimized performance
	private static Config customConfig = initializeHazelcastConfig();
	// defaul config will also work if the object we want to put in a hazelcast IMap if our object implements Serializable class
	private static Config defaultConfig = new Config();
	public static final HazelcastCustomerDaoImpl hazelcastCustomerDaoImpl = new HazelcastCustomerDaoImpl(customConfig);

	private HazelcastDaoUtil() {
	}

	private static Config initializeHazelcastConfig() {
		// Registering a custom Compact Serializer to our config
		Config config = new Config();
		config.getSerializationConfig().getCompactSerializationConfig().addSerializer(new CustomerCompactSerializer());
		return config;
	}

	public static void putCustomerObjectToHazelcast(List<Customer> customers) {
		List<Customer> hazelcastCustomers = customers.stream().filter(customer -> customer.getCustomerId() < 10).toList();
		hazelcastCustomers.stream().forEach(customer -> hazelcastCustomerDaoImpl.put(customer.getCustomerId(), customer));
	}

	public static IMap<Integer, Customer> getCustomerMapFromHazelcast(String mapName) {
		return hazelcastCustomerDaoImpl.getCustomerMap(mapName);
	}

	public static void shutdownHazelcastInstance() {
		hazelcastCustomerDaoImpl.shutdownHazelcast();
	}
}
