package io.github.kprasad99.ribbon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerListFilter;

@Configuration
public class DefaultRibbonConfig {

	@Value("${archaius.deployment.zone:default}")
    private String zone;
	
	@Bean
	public ServerListFilter<Server> ribbonServerListFilter(IClientConfig config) {
		ZkZoneAffinityFilter filter = new ZkZoneAffinityFilter();
		filter.setZone(zone);
		return filter;
	}
}
