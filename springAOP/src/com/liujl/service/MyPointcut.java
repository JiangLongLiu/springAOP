package com.liujl.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myPointcut")
@Aspect
public class MyPointcut {
	@Pointcut("execution(* com.liujl.service.impl.PersonServiceBean.*(..))")
	private void  anyMethod(){};//声明一个切入点
	
	/**
	 * 前置通知
	 * 在某连接点（JoinPoint）之前执行的通知，但这个通知不能阻止连接点前的执行。
	 * ApplicationContext中在<aop:aspect>里面使用<aop:before>元素进行声明。
	 */
	@Before("anyMethod() && args(name)")
	public 	void doAccessCheck(String name){
		System.out.println("前置通知:"+name);
	}
	
	
	/**
	 * 最终通知
	 * 当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）。
	 * ApplicationContext中在<aop:aspect>里面使用<aop:after>元素进行声明。
	 */
	
	@After(value = "anyMethod()")
	public void doAfter(){
		System.out.println("最终通知");
	}
	
	/***
	 *后置通知（After return advice） ：在某连接点正常完成后执行的通知，不包括抛出异常的情况。
	 * ApplicationContext中在<aop:aspect>里面使用<after-returning>元素进行声明。
	 */
	@AfterReturning(value="anyMethod()",returning="result")
	public void doAfterReturning(String result){
		System.out.println("后置通知:"+result);
		
	}
	
	
	/**
	 * 抛出异常后通知
	 * （After throwing advice） ： 在方法抛出异常退出时执行的通知。
	 *  ApplicationContext中在<aop:aspect>里面使用<aop:after-throwing>元素进行声明。
	 */
	@AfterThrowing(value="anyMethod()",throwing="e")
	public void doAfterThrowing(Exception e){
		System.out.println("抛出异常后通知:"+e);
	}
	
	
	@Around(value = "anyMethod()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
	
		System.out.println("进入方法");
		Object result=pjp.proceed();//如果不执行这个方法，那么业务bean的的方法不会被执行
		System.out.println("退出方法");
		return result;
	}
	
}
