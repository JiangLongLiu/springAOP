package com.liujl.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myPointcut")
@Aspect
public class MyPointcut {
	@Pointcut("execution(* com.liujl.service.impl.PersonServiceBean.*(..))")
	private void  anyMethod(){};//声明一个切入点
	@Before("anyMethod()")
	public 	void doAccessCheck(){
		System.out.println("前置通知");
	}
}
