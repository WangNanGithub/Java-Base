package com.devil.designmodel.observe;

// 具体的观察者
public class Teacher implements Observer {

	private Subject subject;

	public void observStudent(Subject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}

	@Override
	public void update(String data) {
		switch (data) {
		case "写作业":
			System.out.println("老师继续观察");
			break;
		case "读书":
			System.out.println("老师继续观察");
			break;
		case "聊天":
			System.out.println("老师批评");
			break;
		case "玩手机":
			System.out.println("老师没收手机");
			break;
		}
	}

}
