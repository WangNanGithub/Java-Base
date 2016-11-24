package com.devil.designmodel.visitor;

/**
 * 访问者
 */
public interface Visitor {
    // 访问工程师类型
    public void visit(Engineer engineer);

    // 访问经理类型
    public void visit(Manager manager);
}
