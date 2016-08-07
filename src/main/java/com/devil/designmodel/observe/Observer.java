package com.devil.designmodel.observe;

/**
 * 
 * @author ys
 * @date 2016年4月21日 下午3:29:16
 * @version 1.0.0
 *
 *          观察者，当主题更新时，调用update来更新数据
 */
public interface Observer {
	public void update(String data);
}
