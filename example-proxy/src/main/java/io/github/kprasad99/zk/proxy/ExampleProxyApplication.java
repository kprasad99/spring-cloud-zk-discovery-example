package io.github.kprasad99.zk.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.github.kprasad99.ribbon.DefaultRibbonConfig;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@RibbonClients(defaultConfiguration = DefaultRibbonConfig.class)
public class ExampleProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleProxyApplication.class, args);
	}

}
