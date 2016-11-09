package com.devil.juc.concurrent.readwrite;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * 对于金钱的操作，需要保证每次数据的正确性
 *
 */
public class MoneyTest {

    public static void main(String[] args) {
        // 创建账户
        MyCount myCount = new MyCount("4238920615242830", 1000);
        // 创建用户，并指定账户
        User user = new User("Tommy", myCount);

        // 分别启动3个“读取账户金钱”的线程 和 3个“设置账户金钱”的线程
        for (int i = 0; i < 3; i++) {
            user.getCash();
            // user.setCash(1000);
        }
    }
}

class User {
    private MyCount myCount; // 所要操作的账户
    private ReadWriteLock myLock; // 执行操作所需的锁对象

    User(String name, MyCount myCount) {
        this.myCount = myCount;
        this.myLock = new ReentrantReadWriteLock();
    }

    // 读取账户金额
    public void getCash() {
        new Thread() {
            public void run() {
                // 获取读取锁
                myLock.readLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " showCash start");
                    myCount.getCash();
                    Thread.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " showCash end");
                } catch (InterruptedException e) {
                } finally {
                    myLock.readLock().unlock();
                }
            }
        }.start();
    }

    // 添加账户金额
    public void setCash(final int cash) {
        new Thread() {
            public void run() {
                // 获取写入锁
                myLock.writeLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " addCash start");
                    myCount.setCash(cash);
                    Thread.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " addCash end");
                } catch (InterruptedException e) {
                } finally {
                    myLock.writeLock().unlock();
                }
            }
        }.start();
    }
}

class MyCount {
    private String id; // 账号
    private int cash; // 账户余额

    MyCount(String id, int cash) {
        this.id = id;
        this.cash = cash;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCash() {
        System.out.println(Thread.currentThread().getName() + " getCash cash=" + cash);
        return cash;
    }

    public void setCash(int cash) {
        this.cash += cash;
        System.out.println(Thread.currentThread().getName() + " setCash cash=" + this.cash);

    }
}