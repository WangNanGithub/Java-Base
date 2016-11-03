package com.devil.designmodel.chain;

public class Client {
    public static void main(String[] args) {
        // 构造3个处理者
        BaseHandler h1 = new Handler1();
        BaseHandler h2 = new Handler2();
        BaseHandler h3 = new Handler3();

        // 设置处理者之间的责任链关系
        h1.nextHandler = h2;
        h2.nextHandler = h3;

        // 构造3个请求者
        BaseRequest r1 = new Request1("obj1");
        BaseRequest r2 = new Request2("obj2");
        BaseRequest r3 = new Request3("obj3");

        h1.handleRequest(r1);
        h1.handleRequest(r2);
        h1.handleRequest(r3);
    }
}
