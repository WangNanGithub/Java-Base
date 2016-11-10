/**
 * ReadWriteLock读写锁
 * 
 * 读写锁可以做到读写分离，如果使用重入锁或内部锁，理论上来说所有的读或者写操作都是串行的
 * 读写锁可以允许多个线程同时读，但是为了保证数据完整性，写写操作和读写操作之间是需要相互等待和只有锁的。
 * 如果系统中，读操作次数较多，则读写锁可以发挥最大作用
 */
package com.devil.juc.concurrent.readwrite;