package com.devil.designmodel.prototype.deep;

import java.io.Serializable;

public class Account implements Serializable {
	private static final long serialVersionUID = -7747721962690262418L;
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
