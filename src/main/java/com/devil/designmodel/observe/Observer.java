package com.devil.designmodel.observe;

/**
 * 观察者，当主题更新时，调用update来更新数据
 */
public interface Observer {
	public void update(String data);
}
