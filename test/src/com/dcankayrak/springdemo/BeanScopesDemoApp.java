package com.dcankayrak.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopesDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScopes-applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		
		System.out.println(result);
		System.out.println(theCoach);
		System.out.println(alphaCoach);

	}

}
