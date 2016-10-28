package com.devil.effective.concurrent.guarded;

/**
 * 服务端
 */
public class ServerThread extends Thread {
    private RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue, String name) {
        /**
         * java类构造方式的执行顺是先构造父类，然后构造子类。 要初始化子类必须先初始其父类。可以不写，但是编译器默认会先执行Super()
         */
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        while (true) {
            final Request request = requestQueue.getRequest();
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " handles " + request);
        }
    }
}
