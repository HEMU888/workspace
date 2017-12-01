package com.hemu.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		/*
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setName("He Mu");
		*/

		ApplicationContext  ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		HelloWorld helloWorld = (HelloWorld)ctx.getBean("helloworld");

		helloWorld.Hello();
	}

}
