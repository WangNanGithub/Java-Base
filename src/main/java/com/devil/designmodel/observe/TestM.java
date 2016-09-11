package com.devil.designmodel.observe;

public class TestM {
	public static void main(String[] args) {
		Student stu = new Student();
		Teacher teacher = new Teacher();
		teacher.observStudent(stu);
		stu.setState("写作业");
		stu.setState("聊天");
		stu.setState("读书");
		stu.setState("玩手机");
	}
}
