package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	@Before("com.luv2code.aopdemo.aspect.AOPExpressions.forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {

		System.out.println("\nRunning @Before Advice on method: @Order(1) \n");

		// display the method signature
		MethodSignature ms = (MethodSignature) joinPoint.getSignature();

		System.out.println("method signature: " + ms + "\n");

		// display the method arguments
		Object[] methodArguments = joinPoint.getArgs();

		for (Object argument : methodArguments) {
			System.out.println("argument: " + argument + "\n");
			if (argument instanceof Account) {
				Account tempAccount = (Account) argument;
				System.out.println("Account name: " + tempAccount.getName());
				System.out.println("Account level: " + tempAccount.getLevel());
			}
		}

	}

}
