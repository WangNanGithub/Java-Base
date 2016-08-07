package com.devil.pro.clone;

public class TestClone {
	public static void main(String[] args) {
		System.out.println("克隆之前:");  
        Address address = new Address("中国", "吉林", "长春");  
        Employee employee1 = new Employee("明日科技", 12, address);  
        System.out.println("员工1信息：" + employee1 );  
          
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
