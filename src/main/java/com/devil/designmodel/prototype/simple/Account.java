package com.devil.designmodel.prototype.simple;

public class Account {
	private String name;
	private String password;

	@Override
	public String toString() {
		return "Acount name:" + name + ",Acount name:" + password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
