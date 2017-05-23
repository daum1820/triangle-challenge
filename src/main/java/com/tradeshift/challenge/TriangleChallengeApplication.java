package com.tradeshift.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class TriangleChallengeApplication {
	public static void main(String[] args) {
		SpringApplication.run(TriangleChallengeApplication.class, args);
	}
}