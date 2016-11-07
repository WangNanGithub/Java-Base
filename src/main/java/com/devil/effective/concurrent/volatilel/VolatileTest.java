package com.devil.effective.concurrent.volatilel;

import org.junit.Test;

/**
 * 例子中没有i，而是比较isExit。例子中说，如果不加volatile，程序需要比加了volatile的代码运行更久，但是从实际测试中比较，效果不明显
 * tryExit的时候，先获取isExit，再会获取一次并计算反值，如果不加volatile，那么在swapValue的时候，第二次isExit的值对于tryExit可能是没有改变的
 * 也就是获取的不是更新后的值，所以一直不会退出
 *
 * 相反，加了i可以稍微看出volatile的作用。不加的时候，还会有部分重复。而加了后，是递增的
 */
public class VolatileTest {
    volatile boolean isExit;
    volatile int i;

    public void tryExit() {
        if (isExit == !isExit) {
            System.exit(0);
        }
    }

    public void swapValue() {
        isExit = !isExit;
    }

    @Test
    public void test() throws InterruptedException {
        final VolatileTest volobj = new VolatileTest();
        Thread mainThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("try exit " + volobj.i);
                    volobj.i++;
                    volobj.tryExit();
                }
            }
        };
        mainThread.start();

        Thread swapThread = new Thread() {
            public void run() {
                while (true) {
                    System.out.println("do swap " + volobj.i);
                    volobj.i++;
                    volobj.swapValue();
                }
            };
        };
        swapThread.start();

        Thread.sleep(1000);
    }
}
