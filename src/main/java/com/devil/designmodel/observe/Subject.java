package com.devil.designmodel.observe;

/**
 * 主题，用于管理监听的观察者，实现数据更新时对他们的通知
 */
public interface Subject {

	public void registerObserver(Observer o);

	public void removeObserver(Observer o);

	public void notifyObserver();
}
