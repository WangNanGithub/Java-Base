package com.devil.designmodel.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 员工业绩报表
 */
public class BusinessReport {
    List<Staff> staffs = new ArrayList<Staff>();

    public BusinessReport() {
        staffs.add(new Manager("李经理"));
        staffs.add(new Manager("陈经理"));
        staffs.add(new Engineer("java-李四"));
        staffs.add(new Engineer("python-张安"));
        staffs.add(new Engineer("C++-赵伟"));
    }

    /**
     * 展示业绩报表
     */
    public void showReport(Visitor visitor) {
        for (Staff staff : staffs) {
            staff.accept(visitor);
        }
    }
}
