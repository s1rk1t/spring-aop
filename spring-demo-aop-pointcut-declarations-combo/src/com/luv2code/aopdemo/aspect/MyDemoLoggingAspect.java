package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {
	}

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter() {
	}

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter() {
	}

	// combine pointcut expression to include all methods in the package except for
	// getters and setters
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	private void forDAOPackageNoGetterSetter() {
	}

	@Before("forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {

		System.out.println("\nRunning @Before Advice on method \n");
	}

	@Before("forDAOPackageNoGetterSetter()")
	public void performAPIAnalytics() {
		System.out.println("Performing API Analytics\n");
	}
}
