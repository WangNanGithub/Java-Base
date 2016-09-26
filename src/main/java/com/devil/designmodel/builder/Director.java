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
		builder.bed(1);
		builder.door(1);
		builder.window(1);
		builder.roof(1);
		builder.wall(4);
	}
}
