package com.dcankayrak.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Before("com.dcankayrak.aopdemo.aspect.MyAopExpressions.forDaoPackageNoGetterSetter()()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=========> Executing @Before Advice on addAccount() ");
	}

}
