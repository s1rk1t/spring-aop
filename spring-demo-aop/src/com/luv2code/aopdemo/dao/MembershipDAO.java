package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public String addMember() {
		System.out.println(getClass() + ": Doing membership work: Adding a membership account");

		return "this is a test string";
	}

	public void goToSleep() {

		System.out.println(getClass() + ": Going to sleep");

	}
}
