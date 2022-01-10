package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read Spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from Spring container
		TrafficFortuneService tfs = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\nMain Around Demo App");

		System.out.println("Calling getFortune()");

		String data = tfs.getFortune();

		System.out.println("Fortune: " + data);

		System.out.println("Finished!");

		// close the context
		context.close();

	}

}
