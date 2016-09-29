/**
 * Copyright (c) 2014-2016 www.nryuncang.com. All Rights Reserved.
 */
package com.devil.designmodel.builder;

/**
 * build管理者
 */
public class Director {
	private Builder builder;

	public Director(Builder builder) {
		this.builder = builder;
	}

	public void construct() {
		builder.wall();
		builder.roof();
		builder.door();
		builder.bed();
	}
}
