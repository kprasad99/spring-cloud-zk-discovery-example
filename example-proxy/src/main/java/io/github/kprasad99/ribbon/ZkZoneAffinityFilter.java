package io.github.kprasad99.ribbon;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.zookeeper.discovery.ZookeeperServer;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerListFilter;

public class ZkZoneAffinityFilter implements ServerListFilter<Server> {

	private static Logger LOG = LoggerFactory.getLogger(ZkZoneAffinityFilter.class);

	private String zone = "default";

	private Predicate<Server> filter = server -> {
		if (server instanceof ZookeeperServer) {
			ZookeeperServer zkServer = (ZookeeperServer) server;
			String str = zkServer.getInstance().getPayload().getMetadata().get("zone");
			return zone.equals(str);
		}
		return true;
	};

	@Override
	public List<Server> getFilteredListOfServers(List<Server> servers) {
		LOG.info("Applying filter for zone: {}", zone);
		List<Server> selected = servers.stream().filter(filter).collect(Collectors.toList());
		return selected.isEmpty() ? servers : selected;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

}
