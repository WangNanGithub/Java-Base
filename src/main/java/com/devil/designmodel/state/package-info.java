/**
 * Copyright(C) 2016 Fugle Technology Co. Ltd. All rights reserved.
 *
 */
/**
 * @author ys
 * @date 2016年8月11日 上午8:38:27
 * @version 1.0.0
 *
 *          状态模式，又称状态对象模式（Pattern of Objects for States），状态模式是对象的行为模式。
 * 
 *          状态模式把所研究的对象的行为包装在不同的状态对象里，每一个状态对象都属于一个抽象状态类的一个子类。
 *          状态模式的意图是让一个对象在其内部状态改变的时候，其行为也随之改变。
 *          
 *          状态模式所涉及到的角色有：
 *          ●　　环境(Context)角色，也成上下文：定义客户端所感兴趣的接口，并且保留一个具体状态类的实例。
 *              这个具体状态类的实例给出此环境对象的现有状态。
 *          ●　　抽象状态(State)角色：定义一个接口，用以封装环境（Context）对象的一个特定的状态所对应的行为。
 *          ●　　具体状态(ConcreteState)角色：每一个具体状态类都实现了环境（Context）的一个状态所对应的行为。
 */
package com.devil.designmodel.state;