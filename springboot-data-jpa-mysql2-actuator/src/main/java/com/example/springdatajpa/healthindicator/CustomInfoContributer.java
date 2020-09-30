package com.example.springdatajpa.healthindicator;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomInfoContributer implements InfoContributor{

	@Override
	public void contribute(Builder builder) {
		builder.withDetail("builder-info", "My Custom Builder").build();
	}

}
