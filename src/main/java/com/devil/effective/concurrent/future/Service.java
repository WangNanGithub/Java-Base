package com.devil.effective.concurrent.future;

import java.util.concurrent.Callable;

/**
 * 服务端
 */
public class Service implements Callable<String> {

    private String para;

    public Service(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        // 这里是正真的业务逻辑，需要执行一段时间
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sBuffer.append(para);
            System.out.println("RealData執行：" + i);
            Thread.sleep(100);
        }
        return sBuffer.toString();
    }

}
