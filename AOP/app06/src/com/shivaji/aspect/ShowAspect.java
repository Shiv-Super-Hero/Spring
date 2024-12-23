package com.shivaji.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class ShowAspect {
	public void before() {
		System.out.println("Get Tickets for the Show");
	}
	public void around(ProceedingJoinPoint pjp) {
		System.out.println("Show is ready to start, take chairs and keep Mobile Phones in Silent mode.");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Show Completed just now, Check luggages");
	}
	public void after() {
		System.out.println("Show is Over Quit from Hall");
	}
	public void afterReturning() {
		System.out.println("ThanQ for attending this Show");
	}
	public void afterThrowing() {
		System.out.println("There is an Interruption in Show, because, Show is not Mimicry show");
	}
}
