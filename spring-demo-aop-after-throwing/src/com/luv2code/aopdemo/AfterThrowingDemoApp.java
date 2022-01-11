package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		// read Spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from Spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = null;
		try {
			// add boolean flag to simulate exception
			boolean excFlag = true;

			accounts = accountDAO.findAccounts(excFlag);

		} catch (Exception e) {

			System.out.println("\nMain program found exception: " + e);

		}
		// display the accounts
		System.out.println("\n========> Main program for @AfterThrowing demo\n");

		System.out.println("-----------------------------------------------------");

		System.out.println(accounts);

		System.out.println("-----------------------------------------------------");

		System.out.println("\n");

		// close the context
		context.close();

	}

}
