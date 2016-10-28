package com.devil.effective.concurrent.future.custom;

/**
 * 客户端
 */
public class Client {

    public Data request(final String queryStr) { // 模仿客户端请求
        final FutureData future = new FutureData();
        new Thread() {
            public void run() { // Realdatae构建很慢，所以放在单独线程中进行
                RealData realData = new RealData(queryStr);
                future.setRealData(realData);
            };
        }.start();
        return future; // futuredata会被立即返回
    }

}
