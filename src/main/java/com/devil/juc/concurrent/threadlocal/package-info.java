/**
 * 线程局部变量
 * 
 * ThreadLocal与synchronize等加锁方式不同，其完全不提供锁，而用空间换时间的手段，为每个线程提供变量的独立副本，保证线程安全
 */
package com.devil.juc.concurrent.threadlocal;