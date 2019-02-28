package io.github.kprasad99.zk.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.kprasad99.zk.proxy.client.ExampleClient;
import reactor.core.publisher.Mono;

@RestController
public class ExampleProxy {

	@Autowired
	private ExampleClient client;

	@GetMapping("/hello")
	public Mono<String> sayHello() {
		return Mono.just(client.sayHello());
	}
}
