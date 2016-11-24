package com.devil.designmodel.visitor;

public class Test {
    public static void main(String[] args) {
        // 构建报表
        BusinessReport report = new BusinessReport();
        System.out.println("=====CEO======");
        report.showReport(new CEO());
        System.out.println("=====CTO======");
        report.showReport(new CTO());
    }
}
