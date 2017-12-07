package com.hemu.spring;

import java.util.Map;

public class NewPerson {
	private String name;
	private int age;
	private Car car;
	private Map<String, Car> cars;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}


	public Map<String, Car> getCars() {
		return cars;
	}
	public void setCars(Map<String, Car> cars) {
		this.cars = cars;
	}
	public NewPerson() {
	}
	public NewPerson(String name, int age, Car car, Map<String, Car> cars) {
		super();
		this.name = name;
		this.age = age;
		this.car = car;
		this.cars = cars;
	}
	@Override
	public String toString() {
		return "NewPerson [name=" + name + ", age=" + age + ", car=" + car + ", cars=" + cars + "]";
	}




}
