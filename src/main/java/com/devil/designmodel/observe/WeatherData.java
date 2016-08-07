package com.devil.designmodel.observe;

import java.util.ArrayList;

/**
 * 
 * @author ys
 * @date 2016年4月21日 下午3:37:04
 * @version 1.0.0
 *
 *          数据主题，用于管理数据更新，以及对观察者的通知
 */
public class WeatherData implements Subject {
	private ArrayList<Observer> observers;
	private String data;

	public WeatherData() {
		observers = new ArrayList<>();
	}

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

	/**
	 * 从气象站通过此方法更新数据给观察者(公告板)
	 */
	public void measurementsChanged() {
		notifyObserver();
	}

	public void setMeasurements(String data) {
		this.data = data;
		measurementsChanged();
	}

	@Override
	public void notifyObserver() {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).update(data);
		}

	}

	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
