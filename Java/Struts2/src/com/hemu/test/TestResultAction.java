package com.hemu.test;

public class TestResultAction {
	private int number;

	public void setNumber(int number) {
		this.number = number;
	}

	public String execute() {
		String result = null;
		if (number%3 == 0){
			result = "success";
		}
		else if(number%3 == 1){
			result = "login";
		}
		else if (number%3 == 2) {
			result = "index";
		}

		return result;
	}
}
