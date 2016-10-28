package com.devil.effective.concurrent.future.custom;

/**
 * 最终使用的数据模型
 */
public class RealData implements Data {
    protected final String result;

    public RealData(String para) {
        // 模拟一个构建很慢的Data，需要用户等待一段时间
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            try {
                // 使用sleep，代替一个很慢的操作
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }

}
