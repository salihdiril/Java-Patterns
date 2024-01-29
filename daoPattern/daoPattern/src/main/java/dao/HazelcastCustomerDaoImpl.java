package dao;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import models.Constants;
import models.Customer;

public class HazelcastCustomerDaoImpl implements CustomerDao<Integer, Customer> {
	private Config config;
	private HazelcastInstance hazelcastInstance;
	private IMap<Integer, Customer> customerMap;

	public HazelcastCustomerDaoImpl(Config config) {
		this.config = config;
		this.hazelcastInstance = Hazelcast.newHazelcastInstance(config);
		this.customerMap = hazelcastInstance.getMap(Constants.HAZELCAST_CUSTOMER_MAP_NAME);
	}

	@Override
	public Customer get(Integer key) {
		return customerMap.get(key);
	}

	@Override
	public Customer put(Integer key, Customer value) {
		return customerMap.put(key, value);
	}

	@Override
	public Customer remove(Integer key) {
		return customerMap.remove(key);
	}

	public IMap<Integer, Customer> getCustomerMap(String mapName) {
		return hazelcastInstance.getMap(mapName);
	}

	public void setCustomerMap(IMap<Integer, Customer> customerMap) {
		this.customerMap = customerMap;
	}

	public void shutdownHazelcast() {
		hazelcastInstance.shutdown();
	}
}


