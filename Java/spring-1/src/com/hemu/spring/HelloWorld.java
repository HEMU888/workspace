package com.hemu.spring;

public class HelloWorld {
	private String name;
	public void setName(String name) {
		this.name = name;
	}

	public void Hello(){
		System.out.println("Hello: " + name);
	}
}
