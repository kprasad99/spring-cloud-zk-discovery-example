package io.github.kprasad99.zk.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {

	@Value("${kp.instance:instance}")
	private String instance;

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello from " + instance;
	}
}
