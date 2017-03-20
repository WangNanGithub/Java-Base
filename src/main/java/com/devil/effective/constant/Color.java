package com.devil.effective.constant;

public enum Color {
	RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
	// 成员变量
	private String name;
	private int index;

	// 构造方法
	private Color(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public String toString() {
		return "id:" + this.index + ",color:" + this.name;
	}

	public enum InColor {
		BLUE("蓝色", 5), BLACK("黑色", 6);
		// 成员变量
		private String name;
		private int index;

		// 构造方法
		private InColor(String name, int index) {
			this.name = name;
			this.index = index;
		}

		public String toString() {
			return "id:" + this.index + ",color:" + this.name;
		}
	}
}