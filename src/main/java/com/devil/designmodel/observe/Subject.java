package com.devil.designmodel.observe;

/**
<<<<<<< HEAD
 * 主题，用于管理监听的观察者，实现数据更新时对他们的通知
=======
 * 
 *          主题，用于管理监听的观察者，实现数据更新时对他们的通知
>>>>>>> bad48b3b58eddd08876de2a40fdf9f9a3eafe3f2
 */
public interface Subject {

	public void registerObserver(Observer o);

	public void removeObserver(Observer o);

	public void notifyObserver();
}
