package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read Spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from Spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call the business methods, note that pertinent advice executes without
		// explicit call in main method

		Account account = new Account();

		accountDAO.addAccount(account, true);

		accountDAO.doWork();

		membershipDAO.addMember();

		membershipDAO.goToSleep();

		// close the context
		context.close();

	}

}
