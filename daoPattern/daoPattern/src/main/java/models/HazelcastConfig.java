package models;

import com.hazelcast.config.Config;
import util.HazelcastDaoUtil;

public enum HazelcastConfig {
	DEFAULT_CONFIG(new Config(), Constants.CLUSTER_NAME),
	CUSTOM_SERIALIZED_CONFIG(HazelcastDaoUtil.initializeCustomHazelcastConfig(), Constants.CLUSTER_NAME);

	private final Config hzConfig;

	HazelcastConfig(Config hzConfig, String clusterName) {
		this.hzConfig = hzConfig;
		hzConfig.setClusterName(clusterName);
	}

	public Config getHzConfig() {
		return hzConfig;
	}
}
