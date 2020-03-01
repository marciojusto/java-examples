package com.reactive.programming.examples;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class ReactiveProgrammingApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void fluxTest() {
		Flux.just("Spring", "Spring Boot", "Reactive Spring Boot")
			.map(s -> s.concat(" Flux"))
			.subscribe(System.out::println);
	}

	@Test
	void monoTest() {
		Mono.just("Spring")
			.map(s -> s.concat(" Flux"))
			.subscribe(System.out::println);
	}
}
