package io.github.kprasad99.zk.proxy.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("egServer")
public interface ExampleClient {

	@GetMapping("/hello")
	String sayHello();
}
