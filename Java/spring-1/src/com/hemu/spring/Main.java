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

		//1.创建Spring的IOC容器
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		HelloWorld helloWorld = (HelloWorld)ctx.getBean("helloworld");
		//HelloWorld helloWorld = (HelloWorld)ctx.getBean(HelloWorld.class);

		helloWorld.Hello();


		Car car = (Car)ctx.getBean("car");
		System.out.println(car);
		Car car2 = (Car) ctx.getBean("car2");

		System.out.println(car2);

		Person person = (Person) ctx.getBean("person");
		System.out.println("person:" + person);

		Person person2 = (Person) ctx.getBean("person2");
		System.out.println("person2" + person2);

		Person person3 = (Person) ctx.getBean("person3");
		System.out.println("person3:" + person3);

		NewPerson newPerson = (NewPerson)ctx.getBean("newPerson");
		System.out.println("newPerson:" + newPerson);

		Person person4 = (Person) ctx.getBean("person4");
		System.out.println("person4:" + person4);

		Person person5 = (Person) ctx.getBean("person5");
		System.out.println("person5:" + person5);
	}

}
