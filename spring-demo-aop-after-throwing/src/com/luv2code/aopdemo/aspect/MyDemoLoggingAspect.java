package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exception")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {

		// print out method we are advising on
		String method = joinPoint.getSignature().toShortString();

		System.out.println("========> executing @AfterThrowing on method: " + method);

		// log the exception to stdout
		System.out.println("========> the exception is: " + exception);

	}

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

	// add new advice for @AfterReturning on findAccounts() method. Note that name
	// of returning="result" matches the name of the List<Account> object in method
	// signature
	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		// print method signature
		String method = joinPoint.getSignature().toShortString();

		System.out.println("========> executing @AfterReturning on method: " + method);

		// print out results of method call
		// Object[] methodArguments = joinPoint.getArgs();
		System.out.println("========> Result is: " + result);

		// modify data before returning it to the calling application
		convertAccountNames(result);

		// verify names have been converted to upper case
		System.out.println("========> Result is: " + result);

	}

	private void convertAccountNames(List<Account> result) {

		for (Account acc : result) {

			String convertedName = acc.getName().toUpperCase();

			acc.setName(convertedName);

		}

	}

}
