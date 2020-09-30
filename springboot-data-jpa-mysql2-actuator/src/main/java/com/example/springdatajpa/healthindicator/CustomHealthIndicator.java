package com.example.springdatajpa.healthindicator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

	@Value("${custom.actuatortest.iserror}")
	private boolean error;
	
	@Override
	public Health health() {
		
		if(error)
			return Health.down().withDetail("error", "My Custom error Message").build();
		
		return Health.up().withDetail("message", "My Custom Message").build();
	}

}
