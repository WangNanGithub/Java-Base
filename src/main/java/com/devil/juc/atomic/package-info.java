/**
 * 原子操作
 * 
 * 无锁的概念：
 * 无锁算法的设计和实现相对复杂许多，但由于非阻塞性，它对死锁免疫，线程间的相互影响也比基于锁的方式要小。
 * CSV(V,E,N)算法，V表示要更新的量，E表示预期值，N表示新值。仅当V等于E时，才将V的值设为N，如果V和E不同，表示其它线程已经做了修改，则当前线程什么都不做。
 * 
 * AtomicInteger JDK 1.7
 * public final int getAndSet(int newValue) {
        for (;;) {                                  // 不停地尝试，直到成功
            int current = get();                    // 取得当前值
            if (compareAndSet(current, newValue))   // 如果当前值未受其它线程影响，则设为新值
                return current;
        }
    }
 */
package com.devil.juc.atomic;