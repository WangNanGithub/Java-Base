package com.devil.pro.clone;
public class Employee implements Cloneable{  
    private String name;  
    private int age;  
    private Address address;  
      
    public Employee(String name, int age, Address address) {  
        super();  
        this.name = name;  
        this.age = age;  
        this.address = address;  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public int getAge() {  
        return age;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  
    public Address getAddress() {  
        return address;  
    }  
    public void setAddress(Address address) {  
        this.address = address;  
    }  
    @Override  
    public Employee clone(){  
        Employee employee = null;  
        try {  
            employee = (Employee) super.clone();
            /**
        	 * 深度克隆 1.实现Cloneable接口 2.重载Object.clone()方法 3.使用对象序列化和反序列化实现深度克隆
        	 * 在浅度克隆的基础上，对于要克隆的对象中的非基本数据类型的属性对应的类，也实现克隆，这样对于非基本数据类型的属性，复制的不是一份引用，
        	 * 即新产生的对象和原始对象中的非基本数据类型的属性指向的不是同一个对象
        	 * 将下面这行注释，注意变化
        	 */
            employee.address = address.clone();  //对引用类型的域进行克隆  
        } catch (CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
        return employee;  
    }  
    @Override  
    public String toString() {  
        StringBuilder sb = new StringBuilder();  
        sb.append("姓名：" + name + ",");  
        sb.append("年龄：" + age+ ", ");  
        sb.append("地址：" + address);  
        return sb.toString();  
    }  
      
    public static void main(String[] args) {  
         
    }  
}