package com.devil.effective.concurrent.future.custom;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        // 这里会立即得到FutureData，但是不是RealData
        Data data = client.request("name");
        System.out.println("请求完毕");
        try {
            // 用sleep代替业务处理
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("数据=" + data.getResult());
    }
}
