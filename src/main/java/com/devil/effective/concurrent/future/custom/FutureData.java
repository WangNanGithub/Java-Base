package com.devil.effective.concurrent.future.custom;

/**
 * 真实数据RealData的代理，封装了获取RealData的等待过程
 */
public class FutureData implements Data { // futuredata是realdata的包装
    protected RealData realData = null;
    protected boolean isReady = false;

    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;
        notifyAll();
    }

    @Override
    public synchronized String getResult() { // 会等待RealData构造完成
        while (!isReady) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return realData.result;
    }

}
