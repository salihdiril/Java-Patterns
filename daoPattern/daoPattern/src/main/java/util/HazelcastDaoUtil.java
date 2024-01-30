package util;

import java.util.List;

import com.hazelcast.config.Config;
import com.hazelcast.map.IMap;
import dao.HazelcastCustomerDaoImpl;
import models.Customer;
import models.HazelcastConfig;

public class HazelcastDaoUtil {
	private static Config defaultConfig = HazelcastConfig.DEFAULT_CONFIG.getHzConfig();
	public static final HazelcastCustomerDaoImpl hazelcastCustomerDaoImpl = new HazelcastCustomerDaoImpl(defaultConfig);

	private HazelcastDaoUtil() {
	}

	public static Config initializeCustomHazelcastConfig() {
		// we can use native serializer of Hazelcast for optimized performance
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
