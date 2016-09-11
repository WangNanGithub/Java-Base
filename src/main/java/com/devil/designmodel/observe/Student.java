package com.devil.designmodel.observe;

import java.util.ArrayList;

// 用于管理数据更新，以及对观察者的通知
public class Student implements Subject {
	private ArrayList<Observer> observers = new ArrayList<>();
	private String state;

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	// 通知观察者
	@Override
	public void notifyObserver() {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).update(state);
		}
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		System.out.println("同学正在" + state);
		notifyObserver();
	}

}
