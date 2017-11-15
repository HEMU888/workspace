package com.hemu.test;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		// TODO 自動生成されたメソッド・スタブ
		return o1.getName().compareTo(o2.getName());
	}

}
