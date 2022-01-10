package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {

		// simulate a 5 second delay

		try {

			TimeUnit.SECONDS.sleep(5);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		// return the fortune
		return "Traffic is mild today";
	}
}
