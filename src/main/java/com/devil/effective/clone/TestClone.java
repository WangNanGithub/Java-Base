package com.devil.effective.clone;

import org.junit.Test;

import com.devil.effective.clone.deep.Address;
import com.devil.effective.clone.deep.Employee;
import com.devil.effective.clone.shallow.Student;

/**
 * 
 *
 * @author yuansheng
 * @version 1.0.0
 */
public class TestClone {

    @Test
    public void testShallow() {
        StringBuffer sprot = new StringBuffer("足球");
        String name = "jack";
        int id = 1;
        String[] className = { "A", "B", "C" };
        System.out.println("克隆之前:");
        Student stu1 = new Student();
        stu1.setId(id);
        stu1.setName(name);
        stu1.setSport(sprot);
        stu1.setClassNames(className);
        System.out.println("学生1信息：" + stu1);

        System.out.println("克隆之后：");
        Student stu2 = stu1.clone();

        sprot.append("和篮球");
        name = "jhon";
        id = 2;
        className[0] = "Z";

        System.out.println("学生1信息：" + stu1);
        System.out.println("学生2信息：" + stu2);

        // 从这里可以看出，浅克隆，会克隆基本类型（String由于是final，所以在克隆后也是会新建一个对象）
        // 对于非基本对象，浅克隆会使用原来对象中的属性对象，比如通过sport和name对比很好看出
    }

    @Test
    public void testDeep() {
        System.out.println("克隆之前:");
        Address address = new Address("中国", "吉林", "长春");
        Employee employee1 = new Employee("明日科技", 12, address);
        System.out.println("员工1信息：" + employee1);

        Employee employee2 = employee1.clone();
        employee2.setAge(11);
        employee2.getAddress().setState("中国");
        employee2.getAddress().setProvince("四川");
        employee2.getAddress().setCity("成都");

        System.out.println("克隆之后：");
        System.out.println("员工2信息：" + employee2);
        System.out.println("员工1信息：" + employee1);
    }
}
