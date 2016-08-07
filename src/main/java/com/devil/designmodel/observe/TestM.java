package com.devil.designmodel.observe;

public class TestM {
	public static void main(String[] args) {
		WeatherData w=new WeatherData();
		CurrentConditionsDisplay d1=new CurrentConditionsDisplay(w);
		CurrentConditionsDisplay d2=new CurrentConditionsDisplay(w);
		w.setMeasurements("吐槽");
		w.setMeasurements("猫");
	}
}
