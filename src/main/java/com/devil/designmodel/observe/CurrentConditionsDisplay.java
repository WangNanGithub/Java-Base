package com.devil.designmodel.observe;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private String data;
	private Subject weatherData;

	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("当前数据为：" + data);
	}

	@Override
	public void update(String data) {
		this.data = data;
		display();

	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Subject getWeatherData() {
		return weatherData;
	}

	public void setWeatherData(Subject weatherData) {
		this.weatherData = weatherData;
	}

}
