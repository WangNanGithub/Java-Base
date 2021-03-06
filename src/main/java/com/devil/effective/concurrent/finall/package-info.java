/**
 * 不变模式
 * 并发操作中，保证对象信息的一致性和正确性，有必要对对象进行同步，但是同步操作是分消耗性能。
 * 所以不变模式的核心思想是当对象创建后，则它的内部状态永远不会发生改变。没有人可以修改其内部状态和数据，同时其内部状态也不会改变。
 * 
 * 不变模式比只读模式更具有一致性和不变性。只读模式本身不能被其他线程修改，但是自己可以被自身对象修改
 * 
 * JDK中的String，基本类型的封装类就是使用此模式
 */
package com.devil.effective.concurrent.finall;