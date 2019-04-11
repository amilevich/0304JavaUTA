package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("aspect")
@Aspect
public class AspectExample {
	
	/*
	 * An advice is an action taken by the aspect. The aspect itself is a class.
	 * 
	 * Pointcut:
	 * "*" - a wildcard for return types and method naming
	 * ".." - a wildcard for our parameter list
	 * "*" - a wildcard for a SINLGE parameter in the parameter list
	 * 
	 * you can specify an access modifier
	 */
	
	@After("execution(public int draw*(*))")
	public void snackingHabit(JoinPoint jp) {
		System.out.println("snack break!");
	}
	
	@Before("execution(* *p*t*er*(..))")
	public void findPotteryMethod(JoinPoint jp) {
		System.out.println("next method will be pottery");
	}
	
	//AROUND EXAMPLE
	@Around("execution(* scul*(..))")
	public void testAroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("wetting the clay");
		pjp.proceed();
		System.out.println("cleaning up mess");
	}

}
