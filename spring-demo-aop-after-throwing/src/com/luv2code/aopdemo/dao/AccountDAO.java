package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;

	private String serviceCode;

	public List<Account> findAccounts(boolean excFlag) throws Exception {

		List<Account> accounts = new ArrayList<>();

		Account account1 = new Account("John Williams", "gold");
		Account account2 = new Account("Barry Goldwater", "silver");
		Account account3 = new Account("John Paul Jones", "platinum");

		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);

		if (excFlag)
			throw new RuntimeException("No soup for you!");

		return accounts;
	}

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": Doing my DB work: Adding an account");
	}

	public boolean doWork() {

		System.out.println(getClass() + ": Doing some work!");

		return false;

	}

	public String getName() {
		System.out.println(getClass() + ": in getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode");
		this.serviceCode = serviceCode;
	}

}
